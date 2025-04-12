package com.easedine.easedine.controller;


import com.easedine.easedine.dto.OrderRequestDTO;
import com.easedine.easedine.dto.OrderResponse;
import com.easedine.easedine.exceptions.UserNotFoundException;
import com.easedine.easedine.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public OrderResponse placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) throws UserNotFoundException {
        return orderService.placeOrder(orderRequestDTO);
    }

}
