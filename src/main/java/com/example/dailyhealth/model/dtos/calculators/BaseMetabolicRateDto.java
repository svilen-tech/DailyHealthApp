package com.example.dailyhealth.model.dtos.calculators;

import com.example.dailyhealth.model.entities.enums.GenderEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BaseMetabolicRateDto {
    private Integer age;
    private GenderEnum gender;
    private Integer height;
    private Integer weight;

    public BaseMetabolicRateDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BaseMetabolicRateDto setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public BaseMetabolicRateDto setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public BaseMetabolicRateDto setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }
}
