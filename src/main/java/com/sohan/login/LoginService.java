package com.sohan.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean isUserValid(String user, String password){
        if(user.equals("sohanjain") && password.equals("12345")){
            return true;
        }
        return false;

    }
}
