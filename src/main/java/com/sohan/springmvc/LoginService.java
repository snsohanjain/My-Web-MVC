package com.sohan.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean isUserValid(String user, String password){
        if(user.equals("Sohan Jain") && password.equals("12345")){
            return true;
        }
        return false;

    }
}
