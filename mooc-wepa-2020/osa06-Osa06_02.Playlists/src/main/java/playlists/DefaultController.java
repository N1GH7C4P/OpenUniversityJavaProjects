package playlists;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("*")
    public String home(Model model) {
        model.addAttribute("otsikko", "Playlist");
        model.addAttribute("sisalto","diibadaabaduu");
        return "index";
    }
}
