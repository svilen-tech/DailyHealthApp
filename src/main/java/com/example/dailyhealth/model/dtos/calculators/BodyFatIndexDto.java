package com.example.dailyhealth.model.dtos.calculators;

import com.example.dailyhealth.model.entities.enums.GenderEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BodyFatIndexDto {

    private GenderEnum genderEnum;
    private Double BMI;
    private Integer age;

    public BodyFatIndexDto setGenderEnum(GenderEnum genderEnum) {
        this.genderEnum = genderEnum;
        return this;
    }

    public BodyFatIndexDto setBMI(Double BMI) {
        this.BMI = BMI;
        return this;
    }

    public BodyFatIndexDto setAge(Integer age) {
        this.age = age;
        return this;
    }
}
