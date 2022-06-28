package projekti.accountManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    SkillRepository skillRepository;
    
    @Autowired
    private ProfileRepository profileRepository;
    
    @ModelAttribute
    private Profile getProfile() {
        return new Profile();
    }
    
    @GetMapping("/index")
    public String viewIndex() {
        return "index";
    }
    
    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }
    
    @GetMapping("/register")
    public String view(@ModelAttribute Profile profile) {
        return "register";
    }
    
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute Profile profile,
            BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()) {
            return "register";
        }
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profileRepository.save(profile);
        return "redirect:/login";
    }
    
    @GetMapping("/profile")
    public String showProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Profile userProfile = profileRepository.findByUsername(auth.getName());
        
        List<Skill> skills = userProfile.getSkills();
        Collections.sort(skills);
        
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("skills", skills);
        return "profile";
    }
    
    @GetMapping("/profile/{username}")
    public String showProfileByUsername(Model model, @PathVariable String username) {
        
        Profile userProfile = profileRepository.findByUsername(username);
        List<Skill> skills = userProfile.getSkills();
        Collections.sort(skills);
        
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("skills", skills);
        return "profile";
    }
}
