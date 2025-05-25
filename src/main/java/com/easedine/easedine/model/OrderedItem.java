package com.easedine.easedine.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderedItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    private  String name;
    private  double price;
    private int quantity;
    private String itemId;

    public int getOrderedItemId() {
        return orderedItemId;
    }

    public void setOrderedItemId(int orderedItemId) {
        this.orderedItemId = orderedItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
