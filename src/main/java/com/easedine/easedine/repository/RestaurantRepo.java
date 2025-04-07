package com.easedine.easedine.repository;


import com.easedine.easedine.model.Restaurant;
import com.easedine.easedine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,String> {
    boolean existsByEmail(String email);

    Optional<Restaurant> findByEmail(String email);
}
