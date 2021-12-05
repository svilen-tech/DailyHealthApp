package com.example.dailyhealth.service;

import com.example.dailyhealth.model.dtos.ExerciseDto;
import com.example.dailyhealth.model.dtos.foodprogramdto.FoodProgramDto;
import com.example.dailyhealth.model.entities.ExerciseEntity;

import java.util.List;

public interface ExerciseService {
    String calculatedTotalCalories(List<ExerciseDto> exercise);
    List<ExerciseDto> returnExercises();
    List<ExerciseEntity> findExercisesBySpecificId(List<ExerciseDto> exerciseDto);
    void addCurrentProgramToDatabase(List<ExerciseDto> exerciseDto, FoodProgramDto foodProgramDto, String username);
}
