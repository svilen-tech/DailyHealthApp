package com.example.dailyhealth.model.dtos.foodprogramdto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ListFoodProgramDto {
    List<FoodProgramDto> foodProgramDtos;

    public ListFoodProgramDto setFoodProgramDtos(List<FoodProgramDto> foodProgramDtos) {
        this.foodProgramDtos = foodProgramDtos;
        return this;
    }
}
