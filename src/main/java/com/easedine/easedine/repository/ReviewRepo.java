package com.easedine.easedine.repository;

import com.easedine.easedine.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewRepo extends JpaRepository<Review,Integer> {
    List<Review> findByCId(String userId);

    List<Review> findByResId(String restaurantId);

}
