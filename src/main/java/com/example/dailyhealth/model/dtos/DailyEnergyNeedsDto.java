package com.example.dailyhealth.model.dtos;

import com.example.dailyhealth.model.entities.enums.ActivityLevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DailyEnergyNeedsDto {
    private ActivityLevelEnum activityLevelEnum;
    private Double estimatedCalories;
    private String goals;

    public DailyEnergyNeedsDto setActivityLevelEnum(ActivityLevelEnum activityLevelEnum) {
        this.activityLevelEnum = activityLevelEnum;
        return this;
    }

    public DailyEnergyNeedsDto setEstimatedCalories(Double estimatedCalories) {
        this.estimatedCalories = estimatedCalories;
        return this;
    }

    public DailyEnergyNeedsDto setGoals(String goals) {
        this.goals = goals;
        return this;
    }
}
