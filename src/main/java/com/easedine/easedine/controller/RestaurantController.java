package com.easedine.easedine.controller;


import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {


    @Autowired
    RestaurantService resServ;

    @GetMapping("/{id}")
    public  Restaurant getResById(@PathVariable String id){
        return resServ.getResById(id);
    }

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurant(){
        return resServ.getAllRestaurant();
    }


    @PutMapping("/update/{id}")
    public Restaurant updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant) {
        return resServ.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable String id) {
        return resServ.deleteRestaurant(id);
    }

    @PostMapping("/register")
    public String registerRes(@RequestBody Restaurant restaurant){
        return resServ.addRestaurant(restaurant);
    }

    @PostMapping("/login")
    public  Restaurant loginRes(@RequestParam String email,@RequestParam  String password){
        return resServ.login(email,password);
    }

}
