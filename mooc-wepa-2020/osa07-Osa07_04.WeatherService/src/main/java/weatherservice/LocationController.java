package weatherservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {
    
    @Autowired
    private WeatherService weatherService;
    
    @Autowired
    private LocationRepository locationRepository;

    
    @GetMapping("/flushcaches")
    public String flushCaches() {
        weatherService.flushCaches();
        return "redirect:/";
    }
    
    @GetMapping("/locations")
    public String list(Model model) {
        model.addAttribute("locations", weatherService.getLocations());
        return "locations";
    }
    
    @GetMapping("/locations/{id}")
    public String view(Model model, @PathVariable Long id) {
        model.addAttribute("location", weatherService.getLocationById(id));
        return "location";
    }

    @PostMapping("/locations")
    public String add(@ModelAttribute Location location) {
        weatherService.addLocation(location);
        return "redirect:/locations";
    }
}
