/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.imageHosting;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import projekti.accountManagement.Profile;
import projekti.accountManagement.ProfileRepository;

/**
 *
 * @author kimmo
 */
@Controller
public class FileObjectController {
    
    @Autowired
    ProfileRepository profileRepository;
    
    @Autowired
    FileObjectRepository fileObjectRepository;
    
    @GetMapping(path = "/images")
    public String viewProfile() {
        return "images";
    }
    
    @GetMapping(path = "/images/{username}/profilepic", produces = "image/gif")
    @ResponseBody
    public byte[] viewContent(@PathVariable String username) throws IOException {
        Profile user = profileRepository.findByUsername(username);
        return user.getProfilePic().getContent();
    }
    
    @PostMapping("/images")
    public String save(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.getContentType().equals("image/gif")) {
            FileObject fo = new FileObject();
            
            fo.setContent(file.getBytes());
            fileObjectRepository.save(fo);
            
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Profile user = profileRepository.findByUsername(auth.getName());
            user.setProfilePic(fo);
            user.setHasProfilePic(true);
            profileRepository.save(user);
        } 
        return "redirect:/images/";
    }
}
