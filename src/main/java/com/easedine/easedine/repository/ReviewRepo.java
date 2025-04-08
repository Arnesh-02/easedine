package com.easedine.easedine.repository;

import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.model.Review;
import com.easedine.easedine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewRepo extends JpaRepository<Review,String> {
    List<Review> findByUserId(User userId);

    List<Review> findByResId(Restaurant restaurantId);

}
