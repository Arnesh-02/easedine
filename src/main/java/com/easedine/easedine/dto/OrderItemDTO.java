package com.easedine.easedine.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OrderItemDTO {
    private String itemId;
    private Integer quantity;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}