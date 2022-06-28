package postredirectget;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostRedirectGetController {

    private List<String> list;
    
    @PostMapping("/")
    public String PostRedirectGetController(@RequestParam String data) {
        this.list = new ArrayList<>();
        this.list.add(data);
        return "redirect:/";
    }
        
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", list);
        return "index";
    }
}
