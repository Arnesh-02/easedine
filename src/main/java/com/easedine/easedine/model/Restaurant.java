package com.easedine.easedine.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int resId;

    private String rname;
    private  String address;
    private String pno;
    private String category;
}
