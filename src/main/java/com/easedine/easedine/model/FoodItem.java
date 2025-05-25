package com.easedine.easedine.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Data
@Table(name = "FoodItem")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int foodItemId;

    private String name;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String imgUrl;
    private double price;
    private float starRating=0.0f;
    private String category;

    @ManyToOne
    @JoinColumn(name = "resId")
    private Restaurant restaurant;

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
