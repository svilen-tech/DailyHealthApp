package com.example.dailyhealth.web;

import com.example.dailyhealth.model.dtos.FoodDto;
import com.example.dailyhealth.model.dtos.ListExerciseDto;
import com.example.dailyhealth.model.dtos.ListFoodDto;
import com.example.dailyhealth.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class FoodController {

    private FoodService foodService;

    @ModelAttribute("foodDto")
    public ListFoodDto foodDto(){
        return new ListFoodDto();
    }


    @GetMapping("choosing/food")
    public String choosingFood(ListFoodDto listFoodDto,Model model){
        listFoodDto.setFoodDtoList(foodService.allFoods());

        model.addAttribute("foodDto",listFoodDto);

        return "foodChoosing";
    }
    @PostMapping("choosing/food")
    public String choosingFoodAdd(@ModelAttribute ListFoodDto listFoodDto, Model model){
        List<FoodDto> collect = listFoodDto.getFoodDtoList().stream()
                .filter(foodDto -> foodDto.getId() != null).collect(Collectors.toList());
        System.out.println();
        return "foodChoosing";
    }

}
