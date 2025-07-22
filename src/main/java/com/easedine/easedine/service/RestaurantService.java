package com.easedine.easedine.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.easedine.easedine.dto.RestaurantRegisterRequestDTO;
import com.easedine.easedine.exceptions.SomethingWenWrongException;
import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {

    @Autowired
    Cloudinary cloud;


    @Autowired
    RestaurantRepo resRepo;

    public String addRestaurant(RestaurantRegisterRequestDTO res) throws SomethingWenWrongException {
        resRepo.save(toRestaurantObj(res));
        return "Restaurant added successfully";
    }

    private Restaurant toRestaurantObj(RestaurantRegisterRequestDTO res) throws SomethingWenWrongException {
        try {
            Restaurant restaurant = new Restaurant();
//            restaurant.setResId(UUID.randomUUID().toString());
            restaurant.setRname(res.getRname());
            restaurant.setCategory(res.getCategory());
            restaurant.setAddress(res.getAddress());
            restaurant.setDescription(res.getDescription());
            restaurant.setOpeningHours(res.getOpeningHours());
            restaurant.setAddress(res.getAddress());
            Map uploadRes = cloud.uploader().upload(res.getProfile_image().getBytes(), ObjectUtils.emptyMap());
            String url = uploadRes.get("url").toString();
            restaurant.setImage_url(url);
            restaurant.setPno(res.getPno());
            restaurant.setEmail(res.getEmail());
            restaurant.setPassword(res.getPassword());
            return restaurant;
        } catch (Exception e) {
            throw new SomethingWenWrongException(e.getMessage().toString());
        }
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
            updatedRes.setPno(updated.getPno());
            updatedRes.setDescription((updated.getDescription()));
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
