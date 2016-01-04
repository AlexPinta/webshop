package Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class JSONController {

    @RequestMapping("/hi")
    @ResponseBody
    public Object[] greeting(){
        return new Object[]{"HELEN", "ALEX"};
    }
}