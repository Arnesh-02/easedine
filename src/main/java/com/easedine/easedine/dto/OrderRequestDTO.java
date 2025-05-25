package com.easedine.easedine.dto;

import com.easedine.easedine.model.OrderedItem;
import com.easedine.easedine.model.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    private int userId;
    private int restaurantId;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private List<OrderItemDTO> items;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
