package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.MesocycleDTO;
import com.resolvedd.workoutapi.model.Mesocycle;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {WorkoutTemplateMapper.class, MesocycleTemplateMapper.class})
public interface MesocycleMapper {

    @Mapping(target = "metadata.id", source = "id")
    @Mapping(target = "metadata.clientId", source = "clientId")
    MesocycleDTO toDTO(Mesocycle mesocycle);

    @Mapping(target = "id", source = "metadata.id")
    @Mapping(target = "clientId", source = "metadata.clientId")
    @Mapping(target = "createdAt", source = "metadata.createdAt")
    @Mapping(target = "updatedAt", source = "metadata.updatedAt")
    @Mapping(target = "deletedAt", source = "metadata.deletedAt")
    @Mapping(target = "userId", ignore = true)
    Mesocycle toEntity(MesocycleDTO mesocycleDTO);

    @AfterMapping
    default void linkScheduledWorkouts(@MappingTarget Mesocycle mesocycle) {
        if (mesocycle.getMesocycleTemplates() != null) {
            mesocycle.getMesocycleTemplates().forEach(template -> template.setMesocycle(mesocycle));
        }
    }
}