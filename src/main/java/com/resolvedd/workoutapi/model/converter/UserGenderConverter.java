package com.resolvedd.workoutapi.model.converter;

import com.resolvedd.workoutapi.exception.UnknownGenderException;
import com.resolvedd.workoutapi.model.UserGender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.GENDER_FEMALE;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.GENDER_MALE;

@Converter(autoApply = true)
public class UserGenderConverter implements AttributeConverter<UserGender, String> {

    @Override
    public String convertToDatabaseColumn(UserGender gender) {
        if (gender == null) return null;
        return gender.getValue();
    }

    @Override
    public UserGender convertToEntityAttribute(String value) {
        if (value == null) return null;
        return switch (value) {
            case GENDER_MALE -> UserGender.MALE;
            case GENDER_FEMALE -> UserGender.FEMALE;
            default -> throw new UnknownGenderException(String.format(UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}