package com.easedine.easedine.controller;

import com.easedine.easedine.model.User;
import com.easedine.easedine.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userv;

    @PostMapping("/register")
    public String registerUser(@RequestBody User us) {
        return userv.register(us);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String pass) {
        return userv.login(email, pass);
    }

    @PutMapping("/password")
    public String forgetPassword(@RequestParam String email,@RequestParam String password) {
        return userv.forgetPassword(email,password);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userv.displayUser(id);
    }

    @PutMapping("/{id}/edit")
    public  User updateDetails(@PathVariable String id ,@RequestBody User us){
        return  userv.updateProfile(id,us);
    }

    @DeleteMapping("/{id}/deleteAcc")
    public  String deleteUser(@PathVariable String id){
        return  userv.deleteUser(id);
    }


}
