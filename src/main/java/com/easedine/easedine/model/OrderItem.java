package com.easedine.easedine.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @JoinColumn( name = "orderId")
    private Order order;

    private  String name;
    private  double price;
    private int quantity;
    private String itemId;

}
