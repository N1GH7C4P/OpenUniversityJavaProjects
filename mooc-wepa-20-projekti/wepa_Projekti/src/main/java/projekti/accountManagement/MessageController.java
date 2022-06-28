/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.accountManagement;

import java.time.LocalDateTime;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kimmo
 */
@Controller
public class MessageController {
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private ProfileRepository profileRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    @ModelAttribute
    private Message getMessage() {
        Message m = new Message();
        return m;
    }
    
    @ModelAttribute
    private Comment getComment() {
        Comment c = new Comment();
        return c;
    }
    
    @GetMapping("messageBoard/{id}/like")
    public String likeMessage(@PathVariable Long id) {
        Message message = messageRepository.getOne(id);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Profile userProfile = profileRepository.findByUsername(name);
        
        if(message.getLikers().contains(userProfile)) {
            return "redirect:/messageBoard";
        }
        message.getLikers().add(userProfile);
        message.setLikes(message.getLikes()+1);
        messageRepository.save(message);
        return "redirect:/messageBoard";
    }
    
    @GetMapping("/messageBoard")
    public String showBoard(Model model) {
        
        Pageable firstPageWith25Messages = PageRequest.of(0, 25, Sort.by("time"));
        Pageable Newest10Comments = PageRequest.of(0, 10);
        
        Page<Message> messages = messageRepository.findAll(firstPageWith25Messages);
        messages.forEach(m -> {
            m.setComments(commentRepository.findBySubjectOrderByTimeDesc(m, Newest10Comments));
        });
        
        model.addAttribute("messages", messages);
        return "messageBoard";
    }
    
    @Transactional
    @PostMapping("/messageBoard/{messageId}/addComment")
    public String postComment(@PathVariable Long messageId, @Valid Model model, @ModelAttribute Comment comment, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return"redirect:/messageBoard";
        }
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Profile userProfile = profileRepository.findByUsername(name);
        
        LocalDateTime time = LocalDateTime.now();
        Message message = messageRepository.findById(messageId).get();
        comment.setTime(time);
        comment.setSender(userProfile);
        comment.setSubject(message);
        message.getComments().add(comment);
        commentRepository.save(comment);
        messageRepository.save(message);
        return"redirect:/messageBoard";
    }
    
    @Transactional
    @PostMapping("/messageBoard")
    public String postMessage(@Valid Model model, @ModelAttribute Message message, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()) {
            return"redirect:/messageBoard";
        }
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Profile userProfile = profileRepository.findByUsername(name);        
        
        LocalDateTime time = LocalDateTime.now();
        message.setSender(userProfile);
        message.setTime(time);
        message.setLikes(0L);
        messageRepository.save(message);
        
        return"redirect:/messageBoard";
        
    }
}
