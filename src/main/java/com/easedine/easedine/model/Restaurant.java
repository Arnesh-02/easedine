package com.easedine.easedine.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    private String resId;

    private String rname;
    private  String address;
    private String email;
    private String pno;
    private String category;
    private double starRating;
    private List<FoodItem> cuisines;
    private String desc;
    private String openingHours;
    private  String password;
}
