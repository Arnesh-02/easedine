package com.easedine.easedine.service;


import com.easedine.easedine.dto.ReviewRequestDTO;
import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.model.Review;
import com.easedine.easedine.model.User;
import com.easedine.easedine.repository.RestaurantRepo;
import com.easedine.easedine.repository.ReviewRepo;
import com.easedine.easedine.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {


    @Autowired
    ReviewRepo revRepo;

    @Autowired
    RestaurantRepo resRepo;

    @Autowired
    UserRepo urepo;

    public String addReview(ReviewRequestDTO dto) {
        Optional<User> user= urepo.findById(dto.getUserId());
        Optional<Restaurant> restaurant = resRepo.findById(dto.getResId());
        if(user.isPresent()){
                if(restaurant.isPresent()){
                    Review review = new Review();
                    review.setrId(UUID.randomUUID().toString());
                    review.setStarRating(dto.getStarRating());
                    review.setComment(dto.getComment());
                    review.setCreatedAt(LocalDateTime.now());
                    review.setUserId(user.get());
                    review.setResId(restaurant.get());
                    revRepo.save(review);
                    return "Review added successfully";
                }
                else {
                    throw  new RuntimeException("Restaurant not found");
                }
        }
        else{
            throw new RuntimeException("User not found");
        }

    }
        public String deleteReview(String reviewId, String userId) {
        Optional<Review> optionalReview = revRepo.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            if (review.getUserId().getUserId().equals(userId))
            {
                revRepo.deleteById(reviewId);
                return "Review deleted successfully";
            } else {
                return "User not authorized to delete this review";
            }
        } else {
            return "Review not found";
        }
    }

    public List<Review> getReviewsByRestaurantId(String restaurantId) {
        Restaurant restaurant = resRepo.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return revRepo.findByResId(restaurant);
    }

    public List<Review> getReviewsByUserId(String userId) {
        User user = urepo.findById(userId).orElseThrow(() -> new RuntimeException("Customer not found"));
        return revRepo.findByUserId(user);
    }
}
