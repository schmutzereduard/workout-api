package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.WorkoutExerciseDTO;
import com.resolvedd.workoutapi.model.WorkoutExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ExerciseMapper.class, ExerciseSetMapper.class })
public interface WorkoutExerciseMapper {

    WorkoutExerciseDTO toDTO(WorkoutExercise workoutExercise);
    WorkoutExercise toEntity(WorkoutExerciseDTO workoutExerciseDTO);
}
