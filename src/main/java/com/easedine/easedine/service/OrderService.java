package com.easedine.easedine.service;


import com.easedine.easedine.dto.OrderItemResponseDTO;
import com.easedine.easedine.dto.OrderRequestDTO;
import com.easedine.easedine.dto.OrderResponse;
import com.easedine.easedine.exceptions.OrderNotFoundException;
import com.easedine.easedine.exceptions.UserNotFoundException;
import com.easedine.easedine.model.*;
import com.easedine.easedine.repository.FoodItemRepo;
import com.easedine.easedine.repository.OrderRepo;
import com.easedine.easedine.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private  OrderRepo orderRepository;

    @Autowired
    private FoodItemRepo foodItemRepo;


    @Autowired
    private UserRepo userRepo;

    public OrderResponse placeOrder(OrderRequestDTO dto) {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setAckId(generateAckId());
        order.setUserId(dto.getCusId());
        order.setResId(dto.getResId());
        order.setDeliveryAddress(dto.getDeliveryAddress());
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setOrderStatus(OrderStatus.ORDER_PLACED);



        List<OrderedItem> orderedItems = dto.getItems().stream().map(itemDto -> {
            FoodItem temp = foodItemRepo.getById(itemDto.getItemId());
            String name = temp.getName();
            double price = temp.getPrice();
            OrderedItem item = new OrderedItem();
            item.setItemId(itemDto.getItemId());
            item.setName(name);
            item.setQuantity(itemDto.getQuantity());
            item.setPrice(price);
            item.setOrder(order); // link to parent
            return item;
        }).collect(Collectors.toList());

        order.setOrderedItems(orderedItems);

        double total = orderedItems.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
        order.setTotalAmount(total);

        orderRepository.save(order); // saves child via cascade

        return mapToOrderResponse(order);
    }


    public OrderResponse cancelOrder(String orderId) throws OrderNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->new OrderNotFoundException("Order not found"));
        if (order.getOrderStatus() == OrderStatus.CANCELLED) {
            throw new IllegalStateException("Order is already cancelled");
        }
        order.setOrderStatus(OrderStatus.CANCELLED);
        Order temp=orderRepository.save(order);
        return mapToOrderResponse(temp);
    }

    public List<OrderResponse> getOrdersByCustomerId(String userId) throws UserNotFoundException {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User is not available");
        }


        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(this::mapToOrderResponse)
                .collect(Collectors.toList());
    }


    private String generateAckId() {
        return String.valueOf(new Random().nextInt(9000) + 1000); // 4-digit
    }

    private OrderResponse mapToOrderResponse(Order order) {
        List<OrderItemResponseDTO> items = order.getOrderedItems().stream().map(item -> {
            OrderItemResponseDTO dto = new OrderItemResponseDTO();
            dto.setItemId(item.getItemId());
            dto.setName(item.getName());
            dto.setQuantity(item.getQuantity());
            dto.setPrice(item.getPrice());
            dto.setSpecialInstructions(""); // Optional
            return dto;
        }).collect(Collectors.toList());

        OrderResponse response = new OrderResponse();
        response.setOrderId(order.getOrderId());
        response.setAckId(order.getAckId());
        response.setUserId(order.getUserId());
        response.setRestaurantId(order.getResId());
        response.setDeliveryFee(0); // You can calculate or customize later
        response.setTotalAmount(order.getTotalAmount());
        response.setPaymentMethod(order.getPaymentMethod());
        response.setDeliveryAddress(order.getDeliveryAddress());
        response.setItems(items);
        response.setStatus(order.getOrderStatus());
        response.setCreatedAt(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
        response.setUpdatedAt(new Timestamp(System.currentTimeMillis()).toLocalDateTime());

        return response;
    }
}
