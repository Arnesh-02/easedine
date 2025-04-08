package com.easedine.easedine.controller;


import com.easedine.easedine.dto.ReviewRequestDTO;
import com.easedine.easedine.model.Review;
import com.easedine.easedine.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService rs;

    @PostMapping("/addReview")
    public String addReview(@RequestBody ReviewRequestDTO dto){
       return rs.addReview(dto);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Review> getReviewsByRestaurant(@PathVariable String restaurantId) {
        return rs.getReviewsByRestaurantId(restaurantId);
    }
    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUser(@PathVariable String userId) {
        return rs.getReviewsByUserId(userId);
    }

    @DeleteMapping("/{reviewId}/user/{userId}")
    public String deleteReview(@PathVariable String reviewId, @PathVariable String userId) {
        return rs.deleteReview(reviewId, userId);
    }

}
