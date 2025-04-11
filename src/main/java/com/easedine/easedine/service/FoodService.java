package com.easedine.easedine.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.easedine.easedine.dto.FoodRequestDTO;
import com.easedine.easedine.dto.FoodResponseDTO;
import com.easedine.easedine.model.FoodItem;
import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.repository.FoodItemRepo;
import com.easedine.easedine.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service
public class FoodService {

    @Autowired
    RestaurantRepo resRepo;

    @Autowired
    Cloudinary cloud;

    @Autowired
    FoodItemRepo foodRepo;


    public FoodResponseDTO addFoodItem(FoodRequestDTO dto) throws IOException {
        Optional<Restaurant> restaurant=resRepo.findById(dto.getRestaurantId());
        if(restaurant.isPresent()){
            Restaurant res=restaurant.get();
            Map uploadRes=cloud.uploader().upload(dto.getImage().getBytes(),ObjectUtils.emptyMap());
            String url=uploadRes.toString();

            FoodItem food=new FoodItem();
            food.setId(UUID.randomUUID().toString());
            food.setName(dto.getName());
            food.setCategory(dto.getCategory());
            food.setDescription(dto.getDescription());
            food.setRestaurant(res);
            food.setPrice(dto.getPrice());
            food.setImgUrl(url);
            food.setStarRating(0.0f);

            FoodItem saved=foodRepo.save(food);
            return toResponseDto(saved);
        }
        else{
            throw new RuntimeException("Restaurant is not available");
        }
    }

    private FoodResponseDTO toResponseDto(FoodItem item) {
        FoodResponseDTO dto = new FoodResponseDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setPrice(item.getPrice());
        dto.setCategory(item.getCategory());
        dto.setImgUrl(item.getImgUrl());
        dto.setStarRating(item.getStarRating());
        dto.setRestaurantName(item.getRestaurant().getRname());
        return dto;
    }

    public FoodResponseDTO getFoodItemById(String id) {
        Optional<FoodItem> foodItem=foodRepo.findById(id);
        if(foodItem.isPresent()){
//            FoodItem food=foodItem.get();
            return  toResponseDto(foodItem.get());
        }
        else{
            throw new RuntimeException("Food item doesn't exists");
        }
    }

    public List<FoodResponseDTO> getAllFoodItem() {
        List<FoodItem> foodList=foodRepo.findAll();
        List<FoodResponseDTO> foodResponseList=new ArrayList<>();

        for(FoodItem i:foodList){
            foodResponseList.add(toResponseDto(i));
        }
        return foodResponseList;
    }

    public List<FoodResponseDTO> getFoodItemsByRestaurant(String resId) {
        List<FoodItem> foodItems = foodRepo.findByRestaurant_ResId(resId);
        List<FoodResponseDTO> responseList = new ArrayList<>();

        for (FoodItem foodItem : foodItems) {
            responseList.add(toResponseDto(foodItem));
        }

        return responseList;
    }


    public ResponseEntity<String> deleteFoodItem(String foodId){
        foodRepo.deleteById(foodId);
        return ResponseEntity.ok("Food Item deleted successfully");
    }
}
