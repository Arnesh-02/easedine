package com.easedine.easedine.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OrderItemDTO {
    private String itemId;
    private String name;
    private Integer quantity;
    private Double price;
}