package com.example.dailyhealth.service;

import com.example.dailyhealth.model.dtos.FoodDto;
import com.example.dailyhealth.model.dtos.FoodTransferDto;

import java.util.List;

public interface FoodService {

    Integer totalCalories(List<FoodDto> foodDtoList);

    List<FoodDto> allFoods();

    void addFood(FoodTransferDto foodDto);
}
