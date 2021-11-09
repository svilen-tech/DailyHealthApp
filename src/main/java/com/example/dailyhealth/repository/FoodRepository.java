package com.example.dailyhealth.repository;

import com.example.dailyhealth.model.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    Optional<Food> findByName(String name);
}
