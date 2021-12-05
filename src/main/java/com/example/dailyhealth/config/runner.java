package com.example.dailyhealth.config;

import com.example.dailyhealth.model.entities.*;
import com.example.dailyhealth.registration.appuser.AppUserRepository;
import com.example.dailyhealth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class runner implements CommandLineRunner {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodProgramRepository foodProgramRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ExercisesRepository exercisesRepository;
    @Autowired
    private PersonalTrainingRepository personalTrainingRepository;

    @Override
    public void run(String... args) throws Exception {
//

        /**
        First go to resources/application.properties and uncommnet #spring.sql.init.mode=always
         then start the project when uncomment everything below, if you stop the project, comment everything back.
         I did not have time for smarter solution for data initialization, I created this only for testing purpose

         */

//ToDo:Meal initialization

//        Meal meal = new Meal();
//        List<Food> list = new ArrayList<>();
//        list.add(foodRepository.findById(1L).get());
//        list.add(foodRepository.findById(2L).get());
//        meal.setFoodList(list);
//        meal.setType("Breakfast");
//        mealRepository.save(meal);
//
//        Meal meal2 = new Meal();
//        List<Food> list2 = new ArrayList<>();
//        list2.add(foodRepository.findById(2L).get());
//        list2.add(foodRepository.findById(3L).get());
//        meal2.setFoodList(list2);
//        meal2.setType("Breakfast");
//        mealRepository.save(meal2);
//        //ToDo:Food program initialization
//        FoodProgram foodProgram = new FoodProgram();
//        foodProgram.setSingleMeal(mealRepository.findById(2l).get());
//        foodProgram.setGoal("Gain");
//        foodProgramRepository.save(foodProgram);
//        //ToDo:Personal Training program initialization
//        TrainingProgram personalTrainingProgram = new TrainingProgram();
//        personalTrainingProgram.setFoodProgram(foodProgramRepository.findById(3L).get());
//        personalTrainingProgram.setAppUser(appUserRepository.findByUsername("svilen12").get());
//        List<ExerciseEntity> exerciseEntityList = new ArrayList<>();
//        exerciseEntityList.add(exercisesRepository.findById(1l).get());
//        exerciseEntityList.add(exercisesRepository.findById(2l).get());
//        personalTrainingProgram.setExerciseEntityList(exerciseEntityList);
//        personalTrainingProgram.setGoal("Gain");
//        personalTrainingRepository.save(personalTrainingProgram);

    }
}
