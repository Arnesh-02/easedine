package com.easedine.easedine.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false)
    private  String name;

    private  String description;
    private String category;

    @Column(nullable = false)
    private String address;
    private  double starRating;

    private List<String> cuisines;
    private  String contactNo;
    private String imageUrl;
    private String openingHours;

    @OneToMany(mappedBy = "restaurant" ,cascade = CascadeType.ALL)
    private List<MenuItem> menuItems=new ArrayList<>();
}
