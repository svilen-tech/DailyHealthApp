package com.example.dailyhealth.model.dtos.foodprogramdto;

import com.example.dailyhealth.model.entities.Meal;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
public class FoodProgramDto {
    private Long id;
    private List<Meal> meals = new ArrayList<>();
    private Integer totalCal;
    private String goal;

    public FoodProgramDto setId(Long id) {
        this.id = id;
        return this;
    }

    public FoodProgramDto setMeals(List<Meal> meals) {
        this.meals = meals;
        return this;
    }

    public FoodProgramDto setTotalCal(Integer totalCal) {
        this.totalCal = totalCal;
        return this;
    }

    public FoodProgramDto setGoal(String goal) {
        this.goal = goal;
        return this;
    }
}
