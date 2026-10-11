package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.MesocycleDTO;
import com.resolvedd.workoutapi.model.Mesocycle;
import com.resolvedd.workoutapi.model.MesocycleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MesocycleMapper {

    @Mapping(target = "status", expression = "java(mapStatusToString(mesocycle.getStatus()))")
    MesocycleDTO toDTO(Mesocycle mesocycle);

    @Mapping(target = "status", expression = "java(mapStringToStatus(mesocycleDTO.getStatus()))")
    Mesocycle toEntity(MesocycleDTO mesocycleDTO);

    default String mapStatusToString(MesocycleStatus status) {
        if (status == null) return null;
        return switch (status) {
                case INACTIVE -> "I";
            case ACTIVE -> "A";
            case COMPLETED -> "C";
        };
    }

    default MesocycleStatus mapStringToStatus(String value) {
        if (value == null) return null;
        return switch (value) {
            case "I" -> MesocycleStatus.INACTIVE;
            case "A" -> MesocycleStatus.ACTIVE;
            case "C" -> MesocycleStatus.COMPLETED;
            default -> throw new IllegalArgumentException("Unexpected status: " + value);
        };
    }
}