package com.easedine.easedine.service;


import com.easedine.easedine.dto.OrderRequestDTO;
import com.easedine.easedine.dto.OrderResponse;
import com.easedine.easedine.exceptions.UserNotFoundException;
import com.easedine.easedine.model.Order;
import com.easedine.easedine.model.OrderItem;
import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.model.User;
import com.easedine.easedine.repository.OrderRepo;
import com.easedine.easedine.repository.RestaurantRepo;
import com.easedine.easedine.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    Order order;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestaurantRepo restaurantRepo;

    public OrderResponse placeOrder(OrderRequestDTO orderRequestDTO) throws UserNotFoundException {

        User cus= userRepo.findById(orderRequestDTO.getCusId()).orElseThrow(()-> new UserNotFoundException("User doesn't exists"));
        Restaurant restaurant = restaurantRepo.findById(orderRequestDTO.getResId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        double totalPrice=0;
        List<OrderItem> lst=orderRequestDTO.getItems();

        for(OrderItem i:lst){
            totalPrice+=i.getPrice()*i.getQuantity();
        }


        Order order = Order.builder()
                .restaurantId(orderRequest.getRestaurantId())
                .userId(orderRequest.getUserId())
                .subtotal(subtotal)
                .taxAmount(taxAmount)
                .deliveryFee(deliveryFee)
                .totalAmount(totalAmount)
                .paymentMethod(orderRequest.getPaymentMethod())
                .deliveryAddress(orderRequest.getDeliveryAddress())
                .specialInstructions(orderRequest.getSpecialInstructions())
                .status(OrderStatus.PENDING)
                .build();
    }
}
