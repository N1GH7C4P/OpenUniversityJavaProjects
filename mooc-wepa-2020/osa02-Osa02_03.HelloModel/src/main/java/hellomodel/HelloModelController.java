package hellomodel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloModelController {
    @GetMapping("/")
    public String home(Model model, @RequestParam String title, @RequestParam String person) {
        model.addAttribute("person", person);
        model.addAttribute("title", title);
        return "index";
    }
}
