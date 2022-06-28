package hellorequestparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloRequestParamController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String param) {
        return "Hello "+param;
    }
}
