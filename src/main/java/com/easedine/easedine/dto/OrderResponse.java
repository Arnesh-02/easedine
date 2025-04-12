package com.easedine.easedine.dto;


import com.easedine.easedine.model.OrderStatus;
import com.easedine.easedine.model.PaymentMethod;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private String orderId;
    private String ackId;
    private String restaurantId;
    private String userId;
    private double deliveryFee;
    private double totalAmount;
    private PaymentMethod paymentMethod;
    private String deliveryAddress;
    private List<OrderItemResponseDTO> items;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
