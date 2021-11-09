package com.example.dailyhealth.repository;

import com.example.dailyhealth.model.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {

}

