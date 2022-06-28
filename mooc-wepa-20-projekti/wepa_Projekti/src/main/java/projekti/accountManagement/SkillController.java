/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.accountManagement;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
public class SkillController {
    
    @Autowired
    private ProfileRepository profileRepository;
    
    @Autowired
    private SkillRepository skillRepository;
    
    @ModelAttribute
    private Skill getSkill() {
        Skill s = new Skill();
        s.setProfilesWithSkill(new ArrayList<Profile>());
        s.setLikes(0L);
        return s;
    }
    
    @GetMapping("/likeSkill/{skillName}")
    public String like(@PathVariable String skillName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Profile userProfile = profileRepository.findByUsername(auth.getName());
        List<Skill> skills = userProfile.getSkills();
        for(Skill s : skills) {
            if(s.getName().equals(skillName)) {
                s.setLikes(s.getLikes()+1);
                skillRepository.save(s);
                return("redirect:/profile");
            }
        }
        return("redirect:/profile");
    }
    
    @PostMapping("/addSkills")
    public String addNewSkill(
            @Valid @ModelAttribute Skill skill, BindingResult bindingResult) {
         
        if(bindingResult.hasErrors()) {
            return"redirect:/addSkills";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Profile userProfile = profileRepository.findByUsername(auth.getName());
        userProfile.getSkills().add(skill);
        skill.getProfilesWithSkill().add(userProfile);
        skillRepository.save(skill);
        profileRepository.save(userProfile);
        
        return"redirect:/skills";
    }
    @GetMapping("/skills")
    public String showForm(@ModelAttribute Skill skill) {
        return "skillsForm";
    }
}
