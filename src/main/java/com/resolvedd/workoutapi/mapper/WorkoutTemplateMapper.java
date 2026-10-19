package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.WorkoutTemplateDTO;
import com.resolvedd.workoutapi.model.WorkoutTemplate;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = TemplateExerciseMapper.class)
public interface WorkoutTemplateMapper {

    @Mapping(target = "metadata.id", source = "id")
    @Mapping(target = "metadata.clientId", source = "clientId")
    @Mapping(target = "metadata.createdAt", source = "createdAt")
    @Mapping(target = "metadata.updatedAt", source = "updatedAt")
    @Mapping(target = "metadata.deletedAt", source = "deletedAt")
    WorkoutTemplateDTO toDTO(WorkoutTemplate workoutTemplate);

    @Mapping(target = "id", source = "metadata.id")
    @Mapping(target = "clientId", source = "metadata.clientId")
    @Mapping(target = "createdAt", source = "metadata.createdAt")
    @Mapping(target = "updatedAt", source = "metadata.updatedAt")
    @Mapping(target = "deletedAt", source = "metadata.deletedAt")
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "mesocycleUsages", ignore = true)
    WorkoutTemplate toEntity(WorkoutTemplateDTO workoutTemplateDTO);

    @AfterMapping
    default void linkTemplateExercises(@MappingTarget WorkoutTemplate workoutTemplate) {
        if (workoutTemplate.getTemplateExercises() != null) {
            workoutTemplate.getTemplateExercises().forEach(exercise -> exercise.setWorkoutTemplate(workoutTemplate));
        }
    }
}
