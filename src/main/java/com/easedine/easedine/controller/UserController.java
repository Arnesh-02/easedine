package com.easedine.easedine.controller;

import com.easedine.easedine.auth.AuthService;
import com.easedine.easedine.exceptions.UserNameNotFoundException;
import com.easedine.easedine.model.User;
import com.easedine.easedine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userv;

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User us) {
        return authService.register(us);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String pass) throws UserNameNotFoundException {
        return authService.login(email, pass);
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
