package com.example.dailyhealth.repository;

import com.example.dailyhealth.model.entities.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainingRepository extends JpaRepository<TrainingProgram,Long> {

}
