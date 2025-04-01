package com.easedine.easedine.controller;


import com.easedine.easedine.model.User;
import com.easedine.easedine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/easedine")
public class UserController {

    @Autowired
    UserService us;

    @PostMapping("/register")

    public ResponseEntity<User> registerUser(@RequestBody ){

    }
}
