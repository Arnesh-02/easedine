package com.easedine.easedine.dto;

import lombok.Data;

@Data
public class OrderItemResponseDTO {
    private String menuItemId;
    private String name;
    private int quantity;
    private double price;
    private String specialInstructions;
}