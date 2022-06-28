package square;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SquareController {
    
    @GetMapping("/square")
    @ResponseBody
    public String Nelio(@RequestParam Integer num) {
        String a = String.valueOf(num*num);
        return a;
    }
}
