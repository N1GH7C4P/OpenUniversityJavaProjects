/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class PresentController {
    
    @Autowired
    PersonRepository personRepository;
    
    @Autowired
    PresentRepository presentRepository;
    
    
    @ModelAttribute
    private Present getPresent() {
        return new Present();
    }
    
    @PostMapping("/presents")
    public String addPresent(@ModelAttribute Present present, @RequestParam(value="id", required=true) Long id) {
        
        Person person = personRepository.getOne(id);
        person.getPresents().add(present);
        personRepository.save(person);
        
        return"redirect:/people/{"+id+"}/presents";
    }
    
    @GetMapping("/people/{personId}/presents")
    public String viewPresents(@PathVariable Long personId, Model model) {
        Person person = personRepository.getOne(personId);
        List<Present> presents = person.getPresents();
        model.addAttribute("presents",presents);
        return "/people/{"+personId+"}/presents";
    }
}
