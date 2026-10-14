package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.MesocycleDTO;
import com.resolvedd.workoutapi.model.Mesocycle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WorkoutTemplateMapper.class})
public interface MesocycleMapper {

    MesocycleDTO toDTO(Mesocycle mesocycle);
    Mesocycle toEntity(MesocycleDTO mesocycleDTO);
}