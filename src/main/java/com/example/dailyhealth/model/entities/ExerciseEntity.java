package com.example.dailyhealth.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercises")
@NoArgsConstructor
@Getter
public class ExerciseEntity {

    @Id
    private Long id;
    private String nameOfExercise;
    private Integer caloriesBurnedForHour;
    @Column(columnDefinition = "TEXT")
    private String bonusInfo;


    public ExerciseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ExerciseEntity setNameOfExercise(String nameOfExercise) {
        this.nameOfExercise = nameOfExercise;
        return this;
    }

    public ExerciseEntity setCaloriesBurnedForHour(Integer caloriesBurnedForHour) {
        this.caloriesBurnedForHour = caloriesBurnedForHour;
        return this;
    }

    public ExerciseEntity setBonusInfo(String bonusInfo) {
        this.bonusInfo = bonusInfo;
        return this;
    }
}
