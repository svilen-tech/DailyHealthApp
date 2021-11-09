package com.example.dailyhealth.service;

import com.example.dailyhealth.model.dtos.foodprogramdto.FoodProgramDto;
import com.example.dailyhealth.model.entities.FoodProgram;


import java.util.List;


public interface FoodProgramService {

    List<FoodProgramDto> allPrograms();
    FoodProgram findFoodProgramById(FoodProgramDto foodProgramDto);
}
