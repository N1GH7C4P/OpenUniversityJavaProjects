package hellorequestparams;

import java.util.Iterator;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloRequestParamsController {
    @GetMapping("/hello")
    @ResponseBody
    public String Greet(@RequestParam String param) {
        return "Hello "+param;
    }
    @GetMapping("/params")
    @ResponseBody
    public String Params(@RequestParam Map<String, String> params) {
        String a = "";
        Iterator i = params.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pair = (Map.Entry)i.next();
            a += (pair.getKey() + " = " + pair.getValue()+", ");
            i.remove();
        }
        return a;
    }
}
