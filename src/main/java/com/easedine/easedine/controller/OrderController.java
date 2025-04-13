package com.easedine.easedine.controller;


import com.easedine.easedine.dto.OrderRequestDTO;
import com.easedine.easedine.dto.OrderResponse;
import com.easedine.easedine.exceptions.OrderNotFoundException;
import com.easedine.easedine.exceptions.UserNotFoundException;
import com.easedine.easedine.service.OrderService;
import lombok.Getter;
import lombok.Locked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public OrderResponse placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) throws UserNotFoundException {
        return orderService.placeOrder(orderRequestDTO);
    }

    @GetMapping("/{userId}")
    public List<OrderResponse> getOrderById(@PathVariable String userId) throws UserNotFoundException {
        return orderService.getOrdersByCustomerId(userId);
    }

    @DeleteMapping("cancelOrder/{orderId}")
    public OrderResponse cancelOrder(@PathVariable String orderId) throws OrderNotFoundException {
        return  orderService.cancelOrder(orderId);
    }
}
