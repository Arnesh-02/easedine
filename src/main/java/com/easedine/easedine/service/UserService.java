package com.easedine.easedine.service;


import com.easedine.easedine.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    public String welcomeUser(String name){
        return "Welcome !.. ";
    }

    public  String register(User user){

    }
}
