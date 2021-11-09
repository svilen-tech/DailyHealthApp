package com.example.dailyhealth.model.dtos.exercises;

import java.util.ArrayList;
import java.util.List;

public class WrapperExerciseEntityDto {
    List<ExerciseEntityDto> exerciseEntityDtoList=new ArrayList<>();

    public WrapperExerciseEntityDto() {
        this.exerciseEntityDtoList=new ArrayList<>();
    }
    public void addToList(ExerciseEntityDto dto){
        exerciseEntityDtoList.add(dto);
    }

    public List<ExerciseEntityDto> getExerciseEntityDtoList() {
        return exerciseEntityDtoList;
    }

    public void setExerciseEntityDtoList(List<ExerciseEntityDto> exerciseEntityDtoList) {
        this.exerciseEntityDtoList = exerciseEntityDtoList;
    }
}
