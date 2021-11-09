package com.example.dailyhealth.model.dtos;

import com.example.dailyhealth.model.entities.FoodProgram;
import com.example.dailyhealth.model.entities.ExerciseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
public class PersonalTrainingProgramDto {

    private Long id;
    private List<ExerciseEntity> exerciseEntityList;
    private FoodProgram foodProgram;
    private String goal;

    public PersonalTrainingProgramDto setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonalTrainingProgramDto setExerciseEntityList(List<ExerciseEntity> exerciseEntityList) {
        this.exerciseEntityList = exerciseEntityList;
        return this;
    }

    public PersonalTrainingProgramDto setFoodProgram(FoodProgram foodProgram) {
        this.foodProgram = foodProgram;
        return this;
    }

    public PersonalTrainingProgramDto setGoal(String goal) {
        this.goal = goal;
        return this;
    }
}
