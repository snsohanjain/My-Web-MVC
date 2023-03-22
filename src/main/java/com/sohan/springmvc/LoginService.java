package com.sohan.springmvc;

public class LoginService {
    public boolean isUserValid(String user, String password){
        if(user.equals("Sohan Jain") && password.equals("12345")){
            return true;
        }
        return false;

    }
}
