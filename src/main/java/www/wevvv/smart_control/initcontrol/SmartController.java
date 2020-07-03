package www.wevvv.smart_control.initcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartController {

    @GetMapping("/login")
    public String index (){
        return "login";
    }


}
