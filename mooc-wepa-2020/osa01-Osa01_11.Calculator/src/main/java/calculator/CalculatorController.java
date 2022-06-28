package calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {
    @GetMapping("/add")
    @ResponseBody
    public String Yhteenlasku(@RequestParam Integer first, @RequestParam Integer second) {
        String a = String.valueOf(first + second);
        return a;
    }
    
    @GetMapping("/multiply")
    @ResponseBody
    public String Kertolasku(@RequestParam Integer first, @RequestParam Integer second) {
        String a = String.valueOf(first * second);
        return a;
    }
}
