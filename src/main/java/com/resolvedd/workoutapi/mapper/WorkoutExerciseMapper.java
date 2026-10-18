package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.WorkoutExerciseDTO;
import com.resolvedd.workoutapi.model.WorkoutExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ExerciseMapper.class, ExerciseSetMapper.class })
public interface WorkoutExerciseMapper {

    WorkoutExerciseDTO toDTO(WorkoutExercise workoutExercise);

    @Mapping(target = "exercise", ignore = true )
    @Mapping(target = "workout", ignore = true)
    WorkoutExercise toEntity(WorkoutExerciseDTO workoutExerciseDTO);
}
