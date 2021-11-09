package com.example.dailyhealth.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class FoodProgram {
    @Id
    @Column(name = "foodprogram_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "foodprogram_meal",
            joinColumns = @JoinColumn(name = "foodprogram_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> meals = new ArrayList<>();
    private Integer totalCal= 0;


    private Integer caloriesTotale(){
        Integer total = 0;
        for (int i = 0; i < meals.size(); i++) {
            total+=meals.get(i).getCalories();
        }
        return total;
    }

    public FoodProgram setId(Long id) {
        this.id = id;
        return this;
    }

    public FoodProgram setMeals(List<Meal> meals) {
        this.meals = meals;
        this.totalCal= totalCal+caloriesTotale();
        return this;
    }
}
