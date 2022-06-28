package profiles;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {
    
    @Autowired
    Environment env;
    
    @Value("${spring.profiles.active:}")
    private String activeProfile;
    
    @ResponseBody
    @GetMapping("/profile")
    public String getProfile() {
        return activeProfile;
    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("profile",activeProfile);
        return "index";
    }
}
