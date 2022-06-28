package reloadheroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ReloadController {
    
    Pageable sortedByScore = 
        PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC,"reloads"));
    
    @Autowired
    private ReloadStatusRepository reloadStatusRepository;
    
    @Autowired
    private ScoreService scoreService;
    
    @RequestMapping("*")
    public String reload(Model model) {
        
        scoreService.incrementScore();
        
        model.addAttribute("scores", reloadStatusRepository.findAll(sortedByScore));
        model.addAttribute("status", scoreService.getPlayerReloadStatus());
        return "index";
    }
}
