package com.sohan.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {
    private final LoginService service;
    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLoginPage(@RequestParam String name, String password, ModelMap model){
        System.out.println(name);
        System.out.println(password);

        if(!service.isUserValid(name,password)) {
            model.put("errorMessage","Invalid Credentials!");
            return "login";
        }else {
            model.put("name", name);
            return "welcome";
        }
    }

}
