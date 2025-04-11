package com.easedine.easedine.controller;


import com.easedine.easedine.dto.FoodRequestDTO;
import com.easedine.easedine.dto.FoodResponseDTO;
import com.easedine.easedine.model.FoodItem;
import com.easedine.easedine.repository.FoodItemRepo;
import com.easedine.easedine.service.FoodService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {


    @Autowired
    FoodService fdServ;

    @PostMapping(value = "/add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FoodResponseDTO addFoodItem(@RequestParam("name") String name,
                                       @RequestParam("description") String description,
                                       @RequestParam("price") double price,
                                       @RequestParam("category") String category,
                                       @RequestParam("restaurantId") String restaurantId, @RequestPart("image")MultipartFile image) throws IOException {
        FoodRequestDTO dto=new FoodRequestDTO();
        dto.setName(name);
        dto.setDescription(description);
        dto.setPrice(price);
        dto.setCategory(category);
        dto.setImage(image);
        dto.setRestaurantId(restaurantId);
        return fdServ.addFoodItem(dto);
    }

    @GetMapping("/{id}")
    public FoodResponseDTO getFoodItemById(@PathVariable String id){
        return fdServ.getFoodItemById(id);
    }

    @GetMapping("/all")
    public List<FoodResponseDTO> getAllFoodItem(){
        return fdServ.getAllFoodItem();
    }


    @GetMapping("/{resId}/all")
    public List<FoodResponseDTO> getAllFoodItemByRestaurant(@PathVariable String resId){
        return fdServ.getFoodItemsByRestaurant(resId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodById(String foodId){
        return  fdServ.deleteFoodItem(foodId);
    }

}
