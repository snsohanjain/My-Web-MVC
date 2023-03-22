package com.sohan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    @ResponseBody
    public String sayHello(){
        return "Hello World !";
    }
    @RequestMapping(value = "/login5")
    @ResponseBody
    public String sayGoodBye(){
        return "Good Bye";
    }

}
