package com.easedine.easedine.respositry;

import com.easedine.easedine.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    List<Restaurant> findResByName(String name);
}
