package com.example.dailyhealth.web;

import com.example.dailyhealth.model.dtos.calculators.BodyFatIndexDto;
import com.example.dailyhealth.model.dtos.calculators.BodyMassIndexDto;
import com.example.dailyhealth.service.StandardCalculators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("calculators")
public class CalculatorsController {

    private final StandardCalculators standardCalorieCalculator;

    public CalculatorsController(StandardCalculators standardCalorieCalculator) {
        this.standardCalorieCalculator = standardCalorieCalculator;
    }


    @ModelAttribute("bodyMassDto")
    public BodyMassIndexDto bodyMassDto() {
        return new BodyMassIndexDto();
    }
    @GetMapping("/bmi")
    public String bmiCalculator() {
        return "calculator/body-mass";
    }

    @PostMapping("/bmi")
    public String bodyMassIndexCalc(@Valid BodyMassIndexDto bodyMassIndexDto, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("bodyMassDto", bodyMassIndexDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bodyMassDto", bindingResult);
            return "redirect:/calculators/bmi";
        }
        String bodyMassIndex = standardCalorieCalculator.calculateBodyMassIndex(bodyMassIndexDto);
        redirectAttributes.addFlashAttribute("bodyMassIndex", bodyMassIndex);
        return "redirect:/calculators/bmi";
    }

    //TODO: BODY FAT CONTROLLER
    @ModelAttribute("bodyFatDto")
    public BodyFatIndexDto bodyFatDto() {
        return new BodyFatIndexDto();
    }

    @GetMapping("/bodyfat")
    public String bodyFatPercentage() {
        return "calculator/body-fat";
    }

    @PostMapping("/bodyfat")
    public String bodyFatPercentageCalc(@Valid BodyFatIndexDto bodyFatIndexDto, BindingResult bindingResult,
                                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("bodyFatDto", bodyFatIndexDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bodyFatDto", bindingResult);
            return "redirect:/calculators/bodyfat";
        }
        String bodyFatPercent = standardCalorieCalculator.calculateBodyFat(bodyFatIndexDto);
        redirectAttributes.addFlashAttribute("bodyFatPercentage", bodyFatPercent);
        return "redirect:/calculators/bodyfat";
    }


}
