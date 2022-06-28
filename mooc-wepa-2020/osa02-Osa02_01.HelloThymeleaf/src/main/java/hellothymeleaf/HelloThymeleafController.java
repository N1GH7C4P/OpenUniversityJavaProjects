package hellothymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloThymeleafController {
    @GetMapping("/")
    public String Home(){
        return "index";
    }
    @GetMapping("/video")
    public String Video(){
        return "video";
    }
}
