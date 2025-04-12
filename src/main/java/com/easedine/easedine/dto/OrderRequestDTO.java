package com.easedine.easedine.dto;

import com.easedine.easedine.model.OrderItem;
import com.easedine.easedine.model.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    private String cusId;
    private String resId;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private List<OrderItem> items;
}
