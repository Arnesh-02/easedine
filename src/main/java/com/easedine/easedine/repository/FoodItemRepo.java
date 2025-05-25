package com.easedine.easedine.repository;

import com.easedine.easedine.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByRestaurant_RestaurantId(int restaurantId);
}
