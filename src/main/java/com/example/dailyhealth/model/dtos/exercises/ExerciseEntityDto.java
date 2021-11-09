package com.example.dailyhealth.model.dtos.exercises;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Getter
@NoArgsConstructor
public class ExerciseEntityDto {
    private String nameOfExercise;
    private Integer caloriesBurnedForHour;
    private String bonusInfo;

    public ExerciseEntityDto setNameOfExercise(String nameOfExercise) {
        this.nameOfExercise = nameOfExercise;
        return this;
    }

    public ExerciseEntityDto setCaloriesBurnedForHour(Integer caloriesBurnedForHour) {
        this.caloriesBurnedForHour = caloriesBurnedForHour;
        return this;
    }

    public ExerciseEntityDto setBonusInfo(String bonusInfo) {
        this.bonusInfo = bonusInfo;
        return this;
    }
}
