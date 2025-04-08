package com.easedine.easedine.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ReviewRequestDTO {
    private int starRating;
    private String comment;
    private String userId;
    private String resId;


    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }
}
