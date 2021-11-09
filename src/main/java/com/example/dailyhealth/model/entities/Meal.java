package com.example.dailyhealth.model.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Food> foodList = new ArrayList<>();
    private String type;
    private Integer calories=0;

    public Meal() {
    }

    private Integer caloriesTotale(){
        Integer total = 0;
        for (Food food : foodList) {
            total += food.getCalories();
        }
        return total;
    }

    public Meal setId(Long id) {
        this.id = id;
        return this;
    }

    public Meal setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        this.calories=this.calories+caloriesTotale();
        return this;
    }

    public Meal setType(String type) {
        this.type = type;
        return this;
    }
}
