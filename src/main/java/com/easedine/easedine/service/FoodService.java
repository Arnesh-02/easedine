package com.easedine.easedine.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.easedine.easedine.model.FoodItem;
import com.easedine.easedine.repository.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service
public class FoodService {

    @Autowired
    Cloudinary cloud;

    @Autowired
    FoodItemRepo foodRepo;

    public FoodItem addFoodItem(FoodItem item, MultipartFile image) throws IOException {
        Map uploadResult = cloud.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
        String imageUrl = uploadResult.get("secure_url").toString();
        item.setImgUrl(imageUrl);
        return foodRepo.save(item);
    }



}
