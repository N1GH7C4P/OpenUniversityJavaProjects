/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.accountManagement;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kimmo
 */

@Controller
public class FriendRequestController {
    
    @Autowired
    ProfileRepository profileRepository;
    
    @Autowired
    FriendRequestRepository friendRequestRepository;
    
    @ModelAttribute
    private FriendRequest getFriendRequest() {
        FriendRequest request = new FriendRequest();
        request.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
        return request;
    }
    
    @Transactional
    @GetMapping("/addfriend/{friendName}")
    public String addFriend(@PathVariable String friendName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String senderName = auth.getName();
        FriendRequest fr = new FriendRequest();
        fr.setSender(senderName);
        fr.setReceiver(friendName);
        friendRequestRepository.save(fr);
        return("redirect:/friends");
    }
    
    @Transactional
    @GetMapping("/remove/{username}")
    public String removeFriend(@PathVariable String username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Profile remover = profileRepository.findByUsername(auth.getName());
        Profile removed = profileRepository.findByUsername(username);
        remover.getFriends().remove(removed);
        removed.getFriends().remove(remover);
        profileRepository.save(removed);
        profileRepository.save(remover);
        return "redirect:/friends";
    }
    
    @GetMapping("/addfriend")
    public String view(Model model) {
        model.addAttribute("request",this.getFriendRequest());
        model.addAttribute("users",profileRepository.findAll());
        return "friendRequestForm";
    }
    
    @GetMapping("/pending")
    public String viewPending(Model model) {
        
        List<FriendRequest> fr = friendRequestRepository.findAll();
        List<FriendRequest> pending = new ArrayList();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Profile userProfile = profileRepository.findByUsername(auth.getName());
        
        for(FriendRequest request : fr) {
            System.out.println(userProfile.getUsername());
            System.out.println(request.getReceiver());
            System.out.println(userProfile.getUsername().equals(request.getReceiver()));
            if(userProfile.getUsername().equals(request.getReceiver())){
                pending.add(request);
            }
        }
        model.addAttribute("pending",pending);
        
        return "pendingRequests";
    }
    
    @PostMapping("/handleRequest/")
    @Transactional
    public String handleRequest(@RequestParam String action, @RequestParam String sender) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String receiver = auth.getName();
        Profile r = profileRepository.findByUsername(receiver);

        FriendRequest request = friendRequestRepository.findByReceiverAndSender(receiver,sender);

        Profile s = profileRepository.findByUsername(sender);
        
        if(action.equals("accept")) {    
            r.getFriends().add(s);
            s.getFriends().add(r);
            profileRepository.save(s);
            profileRepository.save(r);
            friendRequestRepository.delete(request);
        }
        else if(action.equals("decline")) {
            friendRequestRepository.delete(request);
        }
        return "redirect:/friends";
    }
    
    @GetMapping("/friends")
    public String viewFriends(Model model) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String receiver = auth.getName();
        Profile r = profileRepository.findByUsername(receiver);
        
        model.addAttribute("friends",r.getFriends());
        return "friends";
    }
    
    @GetMapping("/requestSent")
    public String viewRequestSentPage() {
        return("requestSent");
    }
}
