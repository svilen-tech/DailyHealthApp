package com.example.dailyhealth.service.Imp;

import com.example.dailyhealth.model.dtos.foodprogramdto.FoodProgramDto;
import com.example.dailyhealth.model.entities.FoodProgram;
import com.example.dailyhealth.repository.FoodProgramRepository;
import com.example.dailyhealth.service.FoodProgramService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodProgramServiceImpl implements FoodProgramService {

    private FoodProgramRepository foodProgramRepository;
    private ModelMapper modelMapper;


    @Override
    public List<FoodProgramDto> allPrograms() {List<FoodProgram> all = foodProgramRepository.findAll();
      List< FoodProgramDto> dtos = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            dtos.add(modelMapper.map(all.get(i),FoodProgramDto.class));
        }
        return dtos;
    }

    @Override
    public FoodProgram findFoodProgramById(FoodProgramDto foodProgramDto) {
        return foodProgramRepository.findById( foodProgramDto.getId()).get();
    }
}
