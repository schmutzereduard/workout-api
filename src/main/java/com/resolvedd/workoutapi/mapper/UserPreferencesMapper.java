package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.UserPreferencesDTO;
import com.resolvedd.workoutapi.model.UserPreferences;
import com.resolvedd.workoutapi.model.enums.WeightUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_WEIGHT_UNIT_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.*;

@Mapper(componentModel = "spring")
public interface UserPreferencesMapper {

    @Mapping(target = "metadata.id", source = "id")
    @Mapping(target = "metadata.clientId", source = "clientId")
    @Mapping(target = "metadata.createdAt", source = "createdAt")
    @Mapping(target = "metadata.updatedAt", source = "updatedAt")
    @Mapping(target = "metadata.deletedAt", source = "deletedAt")
    @Mapping(target = "weightUnit", expression = "java(mapWeightUnitToString(userPreferences.getWeightUnit()))")
    UserPreferencesDTO toDTO(UserPreferences userPreferences);

    @Mapping(target = "id", source = "metadata.id")
    @Mapping(target = "clientId", source = "metadata.clientId")
    @Mapping(target = "createdAt", source = "metadata.createdAt")
    @Mapping(target = "updatedAt", source = "metadata.updatedAt")
    @Mapping(target = "deletedAt", source = "metadata.deletedAt")
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "weightUnit", expression = "java(mapStringToWeightUnit(userPreferencesDTO.weightUnit()))")
    UserPreferences toEntity(UserPreferencesDTO userPreferencesDTO);

    default String mapWeightUnitToString(WeightUnit weightUnit) {
        if (weightUnit == null) return null;
        return weightUnit.getValue();
    }

    default WeightUnit mapStringToWeightUnit(String value) {
        if (value == null) return null;
        return switch (value) {
            case WEIGHT_KG -> WeightUnit.KG;
            case WEIGHT_LBS -> WeightUnit.LBS;
            default -> throw new IllegalArgumentException(String.format(UNKNOWN_WEIGHT_UNIT_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}
