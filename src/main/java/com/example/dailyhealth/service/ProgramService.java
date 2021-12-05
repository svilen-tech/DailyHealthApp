package com.example.dailyhealth.service;

import com.example.dailyhealth.model.dtos.exercises.ExerciseEntityDto;
import com.example.dailyhealth.model.dtos.PersonalTrainingProgramDto;
import com.example.dailyhealth.model.dtos.exercises.WrapperExerciseEntityDto;

import java.util.List;

public interface ProgramService {

    List<PersonalTrainingProgramDto> allPersonalTrainingProgramByName(String username);
    WrapperExerciseEntityDto detailsForExercise(Long id);

    void deleteOffer(Long id);
}
