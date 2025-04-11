package com.easedine.easedine.repository;

import com.easedine.easedine.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,String> {
    List<FoodItem> findByRestaurant_ResId(String resId);
}
