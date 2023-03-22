package com.sohan.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    LoginService service = new LoginService();
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
