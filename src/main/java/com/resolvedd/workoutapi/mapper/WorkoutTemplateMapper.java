package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.WorkoutTemplateDTO;
import com.resolvedd.workoutapi.model.WorkoutTemplate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkoutTemplateMapper {

    WorkoutTemplateDTO toDTO(WorkoutTemplate workoutTemplate);
    WorkoutTemplate toEntity(WorkoutTemplateDTO workoutTemplateDTO);
}
