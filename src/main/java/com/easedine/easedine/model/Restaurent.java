package com.easedine.easedine.model;

import lombok.Data;

import java.util.List;


@Data
public class Restaurent {
    private  int id;
    private  String name;
    private  String description;
    private String category;
    private String address;
    private  double starRating;
    private List<String> cuisines;
    private  String contactNo;
    private String imageUrl;
    private String openingHours;
}
