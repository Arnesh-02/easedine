package com.easedine.easedine.repository;

import com.easedine.easedine.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,String> {
}
