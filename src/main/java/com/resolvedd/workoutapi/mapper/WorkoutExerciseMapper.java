package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.WorkoutExerciseDTO;
import com.resolvedd.workoutapi.model.WorkoutExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ExerciseMapper.class, ExerciseSetMapper.class })
public interface WorkoutExerciseMapper {

    @Mapping(target = "metadata.id", source = "id")
    WorkoutExerciseDTO toDTO(WorkoutExercise workoutExercise);

    @Mapping(target = "id", source = "metadata.id")
    WorkoutExercise toEntity(WorkoutExerciseDTO workoutExerciseDTO);
}
