package com.easedine.easedine.controller;


import com.easedine.easedine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/easedine")
public class UserController {

    @Autowired
    UserService us;

    @RequestMapping("/")
    public String welcome(@PathVariable String name ){
        return us.welcomeUser(name);
    }
}
