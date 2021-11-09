package com.example.dailyhealth.repository;

import com.example.dailyhealth.model.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExercisesRepository extends JpaRepository<ExerciseEntity,Long> {
    Optional<ExerciseEntity> findByNameOfExercise(String name);
}
