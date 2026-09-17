package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.ExerciseSetDTO;
import com.resolvedd.workoutapi.model.ExerciseSet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseSetMapper {

    ExerciseSetDTO toDTO(ExerciseSet exerciseSet);
    ExerciseSet toEntity(ExerciseSetDTO exerciseSet);
}
