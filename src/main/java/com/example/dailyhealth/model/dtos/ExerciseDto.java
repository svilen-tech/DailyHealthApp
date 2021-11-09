package com.example.dailyhealth.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExerciseDto {
    private Long id;
    private String nameOfExercise;


    public ExerciseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public ExerciseDto setNameOfExercise(String nameOfExercise) {
        this.nameOfExercise = nameOfExercise;
        return this;
    }
}
