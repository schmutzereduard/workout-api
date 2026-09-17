package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.ExerciseDTO;
import com.resolvedd.workoutapi.model.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    ExerciseDTO toDTO(Exercise exercise);
    Exercise toEntity(ExerciseDTO exerciseDTO);
}
