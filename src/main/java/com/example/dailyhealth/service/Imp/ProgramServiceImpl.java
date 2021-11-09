package com.example.dailyhealth.service.Imp;

import com.example.dailyhealth.model.dtos.PersonalTrainingProgramDto;
import com.example.dailyhealth.model.dtos.exercises.ExerciseEntityDto;
import com.example.dailyhealth.model.dtos.exercises.WrapperExerciseEntityDto;
import com.example.dailyhealth.model.entities.ExerciseEntity;
import com.example.dailyhealth.model.entities.TrainingProgram;
import com.example.dailyhealth.registration.appuser.AppUserRepository;
import com.example.dailyhealth.repository.PersonalTrainingRepository;
import com.example.dailyhealth.service.ProgramService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private PersonalTrainingRepository personalTrainingRepository;
    private AppUserRepository appUserRepository;
    private ModelMapper modelMapper;

    @Override
    public List<PersonalTrainingProgramDto> allPersonalTrainingProgramByName(String username) {

        Long id = appUserRepository.findByUsername(username).get().getId();
        List<TrainingProgram> collect = personalTrainingRepository.findAll().stream()
                .filter(personalTrainingProgram -> Objects.equals(personalTrainingProgram.getAppUser().getId(), id))
                .collect(Collectors.toList());

        List<PersonalTrainingProgramDto> dtoList = new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            TrainingProgram trainingProgram = collect.get(i);
            trainingProgram.setGoal("Loose weight");
            dtoList.add(modelMapper.map(trainingProgram, PersonalTrainingProgramDto.class));
        }
        return dtoList;
    }

    @Override
    public WrapperExerciseEntityDto detailsForExercise(Long id) {
        List<ExerciseEntity> exerciseEntityList = personalTrainingRepository.findById(id).get().getExerciseEntityList();
        WrapperExerciseEntityDto wrapperExerciseEntityDto = new WrapperExerciseEntityDto();
        for (int i = 0; i < exerciseEntityList.size(); i++) {
            wrapperExerciseEntityDto.addToList(modelMapper.map(exerciseEntityList.get(i), ExerciseEntityDto.class));
        }
        return wrapperExerciseEntityDto;

    }
}
