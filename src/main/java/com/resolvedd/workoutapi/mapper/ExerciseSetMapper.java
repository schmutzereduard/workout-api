package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.ExerciseSetDTO;
import com.resolvedd.workoutapi.exception.UnknownGenderException;
import com.resolvedd.workoutapi.model.ExerciseSet;
import com.resolvedd.workoutapi.model.ExerciseSetType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.*;

@Mapper(componentModel = "spring")
public interface ExerciseSetMapper {

    @Mapping(target = "setType", expression = "java(mapTypeToString(exerciseSet.getSetType()))")
    ExerciseSetDTO toDTO(ExerciseSet exerciseSet);

    @Mapping(target = "setType", expression = "java(mapStringToType(exerciseSetDTO.setType()))")
    @Mapping(target = "workoutExercise", ignore = true)
    ExerciseSet toEntity(ExerciseSetDTO exerciseSetDTO);

    default String mapTypeToString(ExerciseSetType setType) {
        if (setType == null) return null;
        return setType.getValue();
    }

    default ExerciseSetType mapStringToType(String value) {
        if (value == null) return null;
        return switch (value) {
            case WARMUP_SET -> ExerciseSetType.WARMUP;
            case WORKING_SET -> ExerciseSetType.WORKING;
            default -> throw new UnknownGenderException(String.format(UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}
