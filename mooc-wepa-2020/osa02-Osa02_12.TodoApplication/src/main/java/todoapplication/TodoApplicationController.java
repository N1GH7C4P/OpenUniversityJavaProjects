package todoapplication;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoApplicationController {
    
    private Map<String, Item> items;
    
    public TodoApplicationController() {
        this.items = new TreeMap<>();
        Item item = new Item("Käy parturissa.");
        this.items.put(item.getIdentifier(), item);
    }
    
    @PostMapping("/")
    public String post(@RequestParam String name) {
        Item item = new Item(name);
        this.items.put(item.getIdentifier(), item);
        return "redirect:/";
    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", this.items.values());
        return "index";
    }
    
    @GetMapping("/{identifier}")
    public String getOne(Model model, @PathVariable String identifier) {
        Item a = this.items.get(identifier);
        a.Visit();
        model.addAttribute("item", a);
        return "todo";
    }   
}