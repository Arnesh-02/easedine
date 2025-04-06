package com.easedine.easedine.service;


import com.easedine.easedine.model.Review;
import com.easedine.easedine.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {


    @Autowired
    ReviewRepo revRepo;

    public String addReview(Review rev){
        revRepo.save(rev);
        return "Review added successfully";
    }
    public String deleteReview(int reviewId, int userId) {
        Optional<Review> optionalReview = revRepo.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            if (review.getcId().equals(userId)) {
                revRepo.deleteById(reviewId);
                return "Review deleted successfully";
            } else {
                return "User not authorized to delete this review";
            }
        } else {
            return "Review not found";
        }
    }

    public List<Review> getReviewsByUserId(String userId) {
        return revRepo.findByCId(userId);
    }

    public List<Review> getReviewsByRestaurantId(String restaurantId) {
        return revRepo.findByResId(restaurantId);
    }
}
