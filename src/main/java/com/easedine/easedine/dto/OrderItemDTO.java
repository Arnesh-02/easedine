package com.easedine.easedine.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OrderItemDTO {
    private int foodItemId;
    private Integer quantity;

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}