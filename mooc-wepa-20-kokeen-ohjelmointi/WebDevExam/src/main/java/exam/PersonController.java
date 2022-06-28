/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PersonController {
    
    @Autowired
    PersonRepository personRepository;
    
    @ModelAttribute
    private Person getPerson() {
        return new Person();
    }
    
    @PostMapping("/people")
    public String Add(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "people";
        }
        personRepository.save(person);
        return "redirect:/people";
    }
    
    @GetMapping("/people")
    public String List(Model model, @ModelAttribute Person person) {
        List<Person> people = personRepository.findByOrderByName();
        model.addAttribute("people",people);
        return "people";
    }
    
    @GetMapping("/people/{id}")
    public String viewPerson(@PathVariable Long id, Model model, @ModelAttribute Present present, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "person";
        }
        Person person = personRepository.getOne(id);
        model.addAttribute("person", person);
        return "person";
    }
}
