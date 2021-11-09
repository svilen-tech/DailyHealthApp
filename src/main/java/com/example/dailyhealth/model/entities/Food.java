package com.example.dailyhealth.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Food {
    @Id
    @Column(name="FOOD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer calories;

    public Food setId(Long id) {
        this.id = id;
        return this;
    }

    public Food setName(String name) {
        this.name = name;
        return this;
    }

    public Food setCalories(Integer calories) {
        this.calories = calories;
        return this;
    }
}
