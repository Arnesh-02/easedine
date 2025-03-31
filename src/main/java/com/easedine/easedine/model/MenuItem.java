package com.easedine.easedine.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

public class MenuItem {
    private int id;
    private  String name;
    private String description;
    private double price;
    private  double starRating;
    private String category;


}
