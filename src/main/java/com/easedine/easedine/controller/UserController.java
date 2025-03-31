package com.easedine.easedine.controller;


import com.easedine.easedine.model.User;
import com.easedine.easedine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/easedine")
public class UserController {

    @Autowired
    UserService us;

//    @GetMapping("/{name}")
//    public String welcome(@PathVariable String name ){
//        return us.welcomeUser(name);
//    }
    @PostMapping("/register")
    public String  registerUser(User i){
        return us.register(u);
    }
}
