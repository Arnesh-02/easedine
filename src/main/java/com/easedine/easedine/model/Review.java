package com.easedine.easedine.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;
    private float starRating;
    private  String comment;
    private LocalDateTime createdAt;

    // Relationship with other table

    @ManyToOne
    @JoinColumn(name = "userId" ,nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "resId",nullable = false)
    private Restaurant resId;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Restaurant getResId() {
        return resId;
    }

    public void setResId(Restaurant resId) {
        this.resId = resId;
    }
}
