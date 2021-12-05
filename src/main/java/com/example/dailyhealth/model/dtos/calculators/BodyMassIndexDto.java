package com.example.dailyhealth.model.dtos.calculators;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class BodyMassIndexDto {
    @Positive
    @Max(90)
    @NotNull
    private Integer age;
    @Positive
    @Max(150)
    @NotNull
    private Integer weight;
    @Positive
    @Max(220)
    @NotNull
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
