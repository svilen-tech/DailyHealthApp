package com.example.dailyhealth.repository;

import com.example.dailyhealth.model.entities.FoodProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodProgramRepository extends JpaRepository<FoodProgram, Long> {
}
