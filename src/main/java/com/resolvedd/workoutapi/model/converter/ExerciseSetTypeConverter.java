package com.resolvedd.workoutapi.model.converter;

import com.resolvedd.workoutapi.exception.UnknownGenderException;
import com.resolvedd.workoutapi.model.ExerciseSetType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.WARMUP_SET;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.WORKING_SET;

@Converter(autoApply = true)
public class ExerciseSetTypeConverter implements AttributeConverter<ExerciseSetType, String> {

    @Override
    public String convertToDatabaseColumn(ExerciseSetType setType) {
        if (setType == null) return null;
        return setType.getValue();
    }

    @Override
    public ExerciseSetType convertToEntityAttribute(String value) {
        if (value == null) return null;
        return switch (value) {
            case WARMUP_SET -> ExerciseSetType.WARMUP;
            case WORKING_SET -> ExerciseSetType.WORKING;
            default -> throw new UnknownGenderException(String.format(UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}