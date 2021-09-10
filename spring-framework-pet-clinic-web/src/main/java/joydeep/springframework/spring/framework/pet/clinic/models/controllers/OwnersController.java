package joydeep.springframework.spring.framework.pet.clinic.models.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnersController {

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    public String index(){
        return "owners/index";
    }
}
