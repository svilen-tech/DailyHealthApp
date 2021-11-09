package com.example.dailyhealth.service;

import com.example.dailyhealth.model.dtos.DailyEnergyNeedsDto;
import com.example.dailyhealth.model.dtos.calculators.BaseMetabolicRateDto;
import com.example.dailyhealth.model.dtos.calculators.BodyFatIndexDto;
import com.example.dailyhealth.model.dtos.calculators.BodyMassIndexDto;

public interface StandardCalculators {
    String calculateBodyMassIndex(BodyMassIndexDto bodyMassIndexDto);
    String calculateBodyFat(BodyFatIndexDto bodyFatIndexDto);
    Double calculateBaseMetabolicRate(BaseMetabolicRateDto baseMetabolicRateDto);
    DailyEnergyNeedsDto calculateTotalDailyEnergyNeeds(DailyEnergyNeedsDto activity);
    DailyEnergyNeedsDto setGoalBaseOnPreviousResults(DailyEnergyNeedsDto dailyEnergyNeedsDto);
}
