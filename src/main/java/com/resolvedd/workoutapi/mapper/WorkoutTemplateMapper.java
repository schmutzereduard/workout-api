package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.WorkoutTemplateDTO;
import com.resolvedd.workoutapi.model.WorkoutTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TemplateExerciseMapper.class)
public interface WorkoutTemplateMapper {

    @Mapping(target = "mesocycleId", source = "mesocycle.id")
    WorkoutTemplateDTO toDTO(WorkoutTemplate workoutTemplate);

    @Mapping(target = "mesocycle", ignore = true)
    WorkoutTemplate toEntity(WorkoutTemplateDTO workoutTemplateDTO);
}
