package com.easedine.easedine.repository;

import com.easedine.easedine.model.Order;
import com.easedine.easedine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepo extends JpaRepository<Order,String> {
    List<Order> findByUserId(String userId);
}
