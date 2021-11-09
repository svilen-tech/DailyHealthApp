package com.example.dailyhealth.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodDto {

    private Long id;
    private String name;
    private String calories;

    public FoodDto setId(Long id) {
        this.id = id;
        return this;
    }

    public FoodDto setName(String name) {
        this.name = name;
        return this;
    }

    public FoodDto setCalories(String calories) {
        this.calories = calories;
        return this;
    }
}
