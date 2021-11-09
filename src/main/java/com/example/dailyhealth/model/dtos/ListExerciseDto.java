package com.example.dailyhealth.model.dtos;


import com.example.dailyhealth.model.dtos.foodprogramdto.FoodProgramDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
public class ListExerciseDto {
    List<ExerciseDto> exerciseDtoList;
    List<FoodProgramDto> foodProgramDtos;

    public ListExerciseDto setExerciseDtoList(List<ExerciseDto> exerciseDtoList) {
        this.exerciseDtoList = exerciseDtoList;
        return this;
    }

    public ListExerciseDto setFoodProgramDtos(List<FoodProgramDto> foodProgramDtos) {
        this.foodProgramDtos = foodProgramDtos;
        return this;
    }
}
