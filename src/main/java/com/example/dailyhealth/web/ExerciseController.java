package com.example.dailyhealth.web;

import com.example.dailyhealth.model.dtos.ExerciseDto;
import com.example.dailyhealth.model.dtos.foodprogramdto.FoodProgramDto;
import com.example.dailyhealth.model.dtos.ListExerciseDto;
import com.example.dailyhealth.model.dtos.foodprogramdto.ListFoodProgramDto;
import com.example.dailyhealth.service.ExerciseService;
import com.example.dailyhealth.service.FoodProgramService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final FoodProgramService foodProgramService;


    @ModelAttribute("foodProgram")
    public ListFoodProgramDto foodProgram() {
        return new ListFoodProgramDto();
    }

    @ModelAttribute("wrapperExercise")
    public ListExerciseDto exerciseDto() {
        return new ListExerciseDto();
    }

    @GetMapping("/exercises")
    public String exercise(ListExerciseDto wrapper, Model model) {

        wrapper.setExerciseDtoList(exerciseService.returnExercises());
        wrapper.setFoodProgramDtos(foodProgramService.allPrograms());
        model.addAttribute("wrapperExercise", wrapper);
        return "exerciseChoosing";
    }
    @PostMapping("/exercises/add")
    public String exerciseAdd(@ModelAttribute ListExerciseDto listExerciseDto, Model model,
                              final HttpServletRequest request, Principal principal) {
        List<ExerciseDto> exerciseDto = listExerciseDto.getExerciseDtoList().stream()
                .filter(exercise -> exercise.getId() != null).collect(Collectors.toList());

        List<FoodProgramDto> foodProgramDto = listExerciseDto.getFoodProgramDtos().stream().filter(foodProgramDto1 -> foodProgramDto1.getId() != null)
                .collect(Collectors.toList());
        final String currentUser = principal.getName();
        exerciseService.addCurrentProgramToDatabase(exerciseDto, foodProgramDto.get(0), currentUser);
        return "exercises/savedpersonalprogram";

    }


}
