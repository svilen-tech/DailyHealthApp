package com.example.dailyhealth.model.entities;

import com.example.dailyhealth.registration.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class TrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PersonalTP_Exercises")
    private List<ExerciseEntity> exerciseEntityList;
    @ManyToOne
    @JoinColumn(name = "foodProgram_id")
    private FoodProgram foodProgram;
    @ManyToOne
    private AppUser appUser;
    private String goal;

    public TrainingProgram setId(Long id) {
        this.id = id;
        return this;
    }

    public TrainingProgram setExerciseEntityList(List<ExerciseEntity> exerciseEntityList) {
        this.exerciseEntityList = exerciseEntityList;
        return this;
    }

    public TrainingProgram setFoodProgram(FoodProgram foodProgram) {
        this.foodProgram = foodProgram;
        return this;
    }

    public TrainingProgram setAppUser(AppUser appUser) {
        this.appUser = appUser;
        return this;
    }

    public TrainingProgram setGoal(String goal) {
        this.goal = goal;
        return this;
    }
}
