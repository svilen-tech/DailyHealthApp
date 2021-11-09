package com.example.dailyhealth.model.dtos.calculators;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BodyMassIndexDto {
    private Integer age;
    private Integer weight;
    private Integer height;

    public BodyMassIndexDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BodyMassIndexDto setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public BodyMassIndexDto setHeight(Integer height) {
        this.height = height;
        return this;
    }
}
