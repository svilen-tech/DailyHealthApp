package com.example.dailyhealth.service.Imp;

import com.example.dailyhealth.model.dtos.ExerciseDto;
import com.example.dailyhealth.model.dtos.foodprogramdto.FoodProgramDto;
import com.example.dailyhealth.model.entities.ExerciseEntity;
import com.example.dailyhealth.model.entities.TrainingProgram;
import com.example.dailyhealth.registration.appuser.AppUserRepository;
import com.example.dailyhealth.repository.ExercisesRepository;
import com.example.dailyhealth.repository.PersonalTrainingRepository;
import com.example.dailyhealth.service.ExerciseService;
import com.example.dailyhealth.service.FoodProgramService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExercisesRepository exercisesRepository;
    private final ModelMapper modelMapper;
    private final FoodProgramService foodProgramService;
    private final AppUserRepository appUserRepository;
    private final PersonalTrainingRepository personalTrainingRepository;
    @Override
    public String calculatedTotalCalories(List<ExerciseDto> exerciseDto) {

        int totalCalories = 0;
        for (int i = 0; i < exerciseDto.size(); i++) {
            Optional<ExerciseEntity> byIdOfExercise = exercisesRepository.findById(exerciseDto.get(i).getId());
            if (byIdOfExercise.isPresent()) {
                totalCalories += byIdOfExercise.get().getCaloriesBurnedForHour();
            }
        }

        return String.format("Total calories: %d", totalCalories);
    }

    @Override
    public List<ExerciseDto> returnExercises() {
        List<ExerciseEntity> all = exercisesRepository.findAll();
        List<ExerciseDto> list = new ArrayList<>();
        for (ExerciseEntity exerciseEntity : all) {
            ExerciseDto map = map(exerciseEntity);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<ExerciseEntity> findExercisesBySpecificId(List<ExerciseDto> exerciseDto) {

        List<ExerciseEntity> listEntity= new ArrayList<>();
        for (int i = 0; i <exerciseDto.size() ; i++) {
            ExerciseEntity byId = exercisesRepository.findById(exerciseDto.get(i).getId()).get();
            listEntity.add(byId);
        }
        return listEntity;
    }

    @Override
    public void addItToDatabase(List<ExerciseDto> exerciseDto, FoodProgramDto foodProgramDto,String username) {
        TrainingProgram personalTrainingProgram = new TrainingProgram();
        personalTrainingProgram.setExerciseEntityList(findExercisesBySpecificId(exerciseDto));
        personalTrainingProgram.setFoodProgram(foodProgramService.findFoodProgramById(foodProgramDto));
        personalTrainingProgram.setAppUser(appUserRepository.findByUsername(username).get());
        personalTrainingRepository.save(personalTrainingProgram);

    }

    private ExerciseDto map(ExerciseEntity entity) {
        return modelMapper.map(entity, ExerciseDto.class);

    }

}
