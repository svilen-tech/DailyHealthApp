package com.example.dailyhealth.model.dtos;

public class FoodTransferDto {
    private String name;
    private Integer calories;

    public FoodTransferDto() {
    }

    public String getName() {
        return name;
    }

    public FoodTransferDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCalories() {
        return calories;
    }

    public FoodTransferDto setCalories(Integer calories) {
        this.calories = calories;
        return this;
    }
}
