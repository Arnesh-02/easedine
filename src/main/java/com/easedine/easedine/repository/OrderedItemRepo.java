package com.easedine.easedine.repository;

import com.easedine.easedine.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedItemRepo extends JpaRepository<OrderedItem,Long> {
}
