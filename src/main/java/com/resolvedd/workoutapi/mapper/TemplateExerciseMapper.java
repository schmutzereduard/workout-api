package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.TemplateExerciseDTO;
import com.resolvedd.workoutapi.model.TemplateExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TemplateExerciseMapper {

    @Mapping(target = "workoutTemplateId", source = "workoutTemplate.id")
    @Mapping(target = "exerciseId", source = "exercise.id")
    TemplateExerciseDTO toDTO(TemplateExercise templateExercise);

    @Mapping(target = "workoutTemplate", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    TemplateExercise toEntity(TemplateExerciseDTO templateExerciseDTO);
}
