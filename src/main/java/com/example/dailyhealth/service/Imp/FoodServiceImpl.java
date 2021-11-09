package com.example.dailyhealth.service.Imp;

import com.example.dailyhealth.model.dtos.FoodDto;
import com.example.dailyhealth.model.entities.Food;
import com.example.dailyhealth.repository.FoodRepository;
import com.example.dailyhealth.service.FoodService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private ModelMapper modelMapper;



    @Override
    public Integer totalCalories(List<FoodDto> foodDtoList) {
        int totalCalories=0;
        for (int i = 0; i <foodDtoList.size() ; i++) {
            Optional<Food> byNameOfFood = foodRepository.findByName(foodDtoList.get(i).getName());

            if (byNameOfFood.isPresent()){
                totalCalories = byNameOfFood.get().getCalories();
            }

        }
        return totalCalories;
    }

    @Override
    public List<FoodDto> allFoods() {
        List<FoodDto> foodDtoList = new ArrayList<>();
        List<Food> all = foodRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
         foodDtoList.add(modelMapper.map(all.get(i),FoodDto.class));
        }
        return foodDtoList;
    }
}
