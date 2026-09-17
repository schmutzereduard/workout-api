package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.WorkoutDTO;
import com.resolvedd.workoutapi.model.Workout;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WorkoutExerciseMapper.class})
public interface WorkoutMapper {

    WorkoutDTO toDTO(Workout workout);
    Workout toEntity(WorkoutDTO workoutDTO);
}
