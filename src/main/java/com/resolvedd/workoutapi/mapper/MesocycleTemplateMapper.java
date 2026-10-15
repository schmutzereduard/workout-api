package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.MesocycleTemplateDTO;
import com.resolvedd.workoutapi.model.MesocycleTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MesocycleTemplateMapper {

    @Mapping(target = "mesocycleId", source = "mesocycle.id")
    @Mapping(target = "workoutTemplateId", source = "workoutTemplate.id")
    MesocycleTemplateDTO toDTO(MesocycleTemplate mesocycleTemplate);

    @Mapping(target = "mesocycle", ignore = true)
    @Mapping(target = "workoutTemplate", ignore = true)
    MesocycleTemplate toEntity(MesocycleTemplateDTO dto);
}