package com.easedine.easedine.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private  String ackId;
    private  String orderId;
    private  String resId;
    private  String userId;

    private  double totalAmount;
    @Enumerated(EnumType.STRING)
    private  PaymentMethod paymentMethod;
    private  String deliveryAddress;

    @OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL)
    private List<OrderItem> orderedItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @CreationTimestamp
    private Timestamp orderAt;

    @UpdateTimestamp
    private  Timestamp updatedAt;

}
