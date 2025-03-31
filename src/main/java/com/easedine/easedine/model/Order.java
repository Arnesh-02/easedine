package com.easedine.easedine.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.Date;


@Data
public class Order {
    private  int id;
    private  int cusId;
    private  int resId;
    private double tPrice;
    private OrderStatus status;
    private String Address;
    private Date OrderTime;
    private  int deliveryPersonId;
}
