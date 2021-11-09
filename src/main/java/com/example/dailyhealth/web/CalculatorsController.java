package com.example.dailyhealth.web;

import com.example.dailyhealth.model.dtos.calculators.BodyFatIndexDto;
import com.example.dailyhealth.model.dtos.calculators.BodyMassIndexDto;
import com.example.dailyhealth.service.StandardCalculators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @PostMapping("/bodymass")
    public String bodyMassIndexCalc(BodyMassIndexDto bodyMassIndexDto, RedirectAttributes model) {
        String bodyMassIndex = standardCalorieCalculator.calculateBodyMassIndex(bodyMassIndexDto);
        model.addFlashAttribute("bodyMassIndex", bodyMassIndex);
        return "redirect:/calculators/both";
    }

    //TODO: BODY FAT CONTROLLER
    @ModelAttribute("bodyFatDto")
    public BodyFatIndexDto bodyFatDto() {
        return new BodyFatIndexDto();
    }

    @GetMapping("/both")
    public String bodyFatPercentage() {
        return "bothcalculatorshere";
    }

    @PostMapping("/bodyfat")
    public String bodyFatPercentageCalc(BodyFatIndexDto bodyFatIndexDto, RedirectAttributes model) {
        String bodyFatPercent = standardCalorieCalculator.calculateBodyFat(bodyFatIndexDto);
        model.addFlashAttribute("bodyFatPercentage", bodyFatPercent);
        return "redirect:/calculators/both";
    }


}
