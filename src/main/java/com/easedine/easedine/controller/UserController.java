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
public class UserController {

    @Autowired
    UserService userv;

    @GetMapping("/")
    public void redirect(HttpServletResponse rp) throws IOException {
        rp.sendRedirect("/swagger-ui.html");
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User us) {
        return userv.register(us);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String pass) {
        return userv.login(email, pass);
    }

//    @PutMapping("/{id}/password")
//    public String forgetPassword(@PathVariable int id, @RequestParam String email) {
//        return userv.forgetPassword(id, email);
//    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userv.displayUser(id);
    }

//    @PutMapping("/{id}/edit")
//    public  User updateDetails(@PathVariable int id ,@RequestBody User us){
//        return  userv.updateProfile(id,us);
//    }
//
    @DeleteMapping("/{id}/deleteAcc")
    public  String deleteUser(@PathVariable int id){
        return  userv.deleteUser(id);
    }

//    @GetMapping("/{id}/pastorders")
//    public List<Order> getOrders(@PathVariable int id){
//        return userv.getOrders(id);
//    }
//
//    @PostMapping("/{id}/review")
//    public String submitReview(@PathVariable int id,@RequestParam int resId,@RequestParam int rating,@RequestParam String comment) {
//        return userv.submitReview(id, resId, rating, comment);
//    }
}
