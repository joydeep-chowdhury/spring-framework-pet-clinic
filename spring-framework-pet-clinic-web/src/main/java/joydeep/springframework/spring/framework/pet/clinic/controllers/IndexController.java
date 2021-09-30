package joydeep.springframework.spring.framework.pet.clinic.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Profile("jpa")
public class IndexController {

    @RequestMapping({"","/index","/","/index.html"})
    public String index(){
        return "index";
    }
}
