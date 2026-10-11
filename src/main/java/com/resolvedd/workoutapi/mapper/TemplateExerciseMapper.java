package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.TemplateExerciseDTO;
import com.resolvedd.workoutapi.model.TemplateExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemplateExerciseMapper {

    TemplateExerciseDTO toDTO(TemplateExercise templateExercise);
    TemplateExercise toEntity(TemplateExerciseDTO templateExerciseDTO);
}
