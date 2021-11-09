package com.example.dailyhealth.service.Imp;

import com.example.dailyhealth.model.dtos.DailyEnergyNeedsDto;
import com.example.dailyhealth.model.dtos.calculators.BaseMetabolicRateDto;
import com.example.dailyhealth.model.dtos.calculators.BodyFatIndexDto;
import com.example.dailyhealth.model.dtos.calculators.BodyMassIndexDto;
import com.example.dailyhealth.service.StandardCalculators;
import org.springframework.stereotype.Service;

@Service
public class StandardCalculatorsImpl implements StandardCalculators {

    @Override
    public String calculateBodyMassIndex(BodyMassIndexDto bodyMassIndexDto) {

        //TODO: here we are using standard BMI formula
        int weightInKg = bodyMassIndexDto.getWeight();
        int heightInCm = bodyMassIndexDto.getHeight();
        double bmi = ((double) weightInKg / heightInCm / heightInCm) * 10000;

        String messageForBmi = "";
        if (bmi < 16) {
            messageForBmi = "Severe Thinness";
        } else if (bmi <= 17) {
            messageForBmi = "Moderate Thinness";
        } else if (bmi <= 18.5) {
            messageForBmi = "mild Thinness";
        } else if (bmi <= 25) {
            messageForBmi = "Normal";
        } else {
            messageForBmi = "Overweight";
        }
        return String.format("BMI = %.2f kg/m2 (%s)", bmi, messageForBmi);
    }

    @Override
    public String calculateBodyFat(BodyFatIndexDto bodyFatIndexDto) {
        //TODO: here we are using standard BodyFatPercentage formula
        //cutting phase = -560 calories
        //bulking phase + 15% more calories
        //recomp = same
        double indexDependingOnGender = 0;
        if (bodyFatIndexDto.getGenderEnum().toString().equals("female")) {
            indexDependingOnGender = 5.4;
        } else {
            indexDependingOnGender = 16.2;
        }
        return String.format("%.2f %%", (1.20 * bodyFatIndexDto.getBMI()) + (0.23 * bodyFatIndexDto.getAge()) - indexDependingOnGender);
    }

    @Override
    public Double calculateBaseMetabolicRate(BaseMetabolicRateDto baseMetabolicRateDto) {
        double genderValue = baseMetabolicRateDto.getGender().toString().equals("MALE") ? 88.362 : 447.593;
        int weight = baseMetabolicRateDto.getWeight();
        int height = baseMetabolicRateDto.getHeight();
        int years = baseMetabolicRateDto.getAge();
        return rawCalculatorForBaseMetabolicRate(genderValue, weight, height, years);
    }

    @Override
    public DailyEnergyNeedsDto calculateTotalDailyEnergyNeeds(DailyEnergyNeedsDto dailyEnergyNeedsDto) {
        double activityFactor =dailyEnergyNeedsDto.getEstimatedCalories();
        switch (dailyEnergyNeedsDto.getActivityLevelEnum().toString().toLowerCase()) {
            case "sedentary":
                activityFactor *= 1.2;
                break;
            case "lightly Active":
                activityFactor *=  1.375;
                break;
            case "moderately Active":
                activityFactor *=  1.55;
                break;
            case "very Active":
                activityFactor *=  1.725;
                break;
        }
        dailyEnergyNeedsDto.setEstimatedCalories(activityFactor);
        return dailyEnergyNeedsDto;
    }

    @Override
    public DailyEnergyNeedsDto setGoalBaseOnPreviousResults(DailyEnergyNeedsDto dailyEnergyNeedsDto) {
        Double caloriesUntilNow = dailyEnergyNeedsDto.getEstimatedCalories();
        switch (dailyEnergyNeedsDto.getGoals()){
            case "cutting":
                caloriesUntilNow -=560;
                break;
            case"bulking":
                caloriesUntilNow*=0.85;
                break;
            case "recomp":
                break;
        }
        dailyEnergyNeedsDto.setEstimatedCalories(caloriesUntilNow);
        return dailyEnergyNeedsDto;
    }

    private double rawCalculatorForBaseMetabolicRate(double genderValue, int weight, int height, int years) {
        return genderValue + (13.397 * weight) + (4.799 * height) - (5.677 * years);
    }
}
