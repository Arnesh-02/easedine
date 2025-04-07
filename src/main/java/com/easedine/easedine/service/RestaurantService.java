package com.easedine.easedine.service;


import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.model.User;
import com.easedine.easedine.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {


    @Autowired
    RestaurantRepo resRepo;

    public String addRestaurant(Restaurant res) {
        resRepo.save(res);
        return "Restaurant added successfully";
    }

    public Restaurant getResById(String id) {
        Optional<Restaurant> opt=resRepo.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
            throw  new RuntimeException("No such Restaurant exists");
        }
    }

    public List<Restaurant> getAllRestaurant() {
        return resRepo.findAll();
    }


    public Restaurant updateRestaurant(String id, Restaurant updated) {
        Optional<Restaurant> res=resRepo.findById(id);
        if(res.isPresent()){
            Restaurant updatedRes=res.get();
            updatedRes.setDesc(updated.getDesc());
            updatedRes.setPno(updated.getPno());
            updatedRes.setCuisines(updated.getCuisines());
            updatedRes.setAddress(updated.getAddress());
            updatedRes.setOpeningHours(updated.getOpeningHours());
            updatedRes.setRname(updated.getRname());
            updatedRes.setCategory(updated.getCategory());
            return resRepo.save(updatedRes);

        }
        else{
            throw  new RuntimeException("Cannot Update the restaurant");
        }
    }

    public String deleteRestaurant(String id) {
        Optional<Restaurant> res=resRepo.findById(id);
        if(res.isPresent()){
            resRepo.deleteById(id);
            return  "Account deleted successfully";
        }
        else{
            throw  new RuntimeException("No such account exists");
        }
    }

    public Restaurant login(String email, String password) {
        Optional<Restaurant> optRes = resRepo.findByEmail(email);
        if (optRes.isPresent()) {
            Restaurant res = optRes.get();
            if (res.getPassword().equals(password)) {
                return res;
            } else {
                throw new RuntimeException("Incorrect password");
            }
        } else {
            throw new RuntimeException("Restaurant not found with email: " + email);
        }
    }

}
