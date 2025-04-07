package com.easedine.easedine.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "FoodItem")
public class FoodItem {
    @Id
    private String id;

    private String name;
    private String description;
    private double price;
    private int starRating;
    private String category;
    private String imgUrl;
}
