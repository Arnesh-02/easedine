package com.easedine.easedine.dto;

import com.easedine.easedine.model.OrderedItem;
import com.easedine.easedine.model.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    private String cusId;
    private String resId;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private List<OrderItemDTO> items;

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
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
