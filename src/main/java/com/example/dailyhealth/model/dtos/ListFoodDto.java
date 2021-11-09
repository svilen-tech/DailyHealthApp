package com.example.dailyhealth.model.dtos;

import java.util.List;


public class ListFoodDto {
    private List<FoodDto> foodDtoList;

    public ListFoodDto() {
    }

    public List<FoodDto> getFoodDtoList() {
        return foodDtoList;
    }

    public ListFoodDto setFoodDtoList(List<FoodDto> foodDtoList) {
        this.foodDtoList = foodDtoList;
        return this;
    }
}
