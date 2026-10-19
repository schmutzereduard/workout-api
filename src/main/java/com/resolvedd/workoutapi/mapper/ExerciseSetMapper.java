package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.ExerciseSetDTO;
import com.resolvedd.workoutapi.model.ExerciseSet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseSetMapper {

    ExerciseSetDTO toDTO(ExerciseSet exerciseSet);

    @Mapping(target = "workoutExercise", ignore = true)
    ExerciseSet toEntity(ExerciseSetDTO exerciseSet);
}
