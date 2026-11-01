package com.resolvedd.workoutapi.model.converters;

import com.resolvedd.workoutapi.model.enums.WeightUnit;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_WEIGHT_UNIT_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.WEIGHT_KG;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.WEIGHT_LBS;

@Converter(autoApply = true)
public class WeightUnitConverter implements AttributeConverter<WeightUnit, String> {


    @Override
    public String convertToDatabaseColumn(WeightUnit weightUnit) {
        if (weightUnit == null) return null;
        return weightUnit.getValue();
    }

    @Override
    public WeightUnit convertToEntityAttribute(String value) {
        if (value == null)
            return null;

        return switch (value) {
            case WEIGHT_LBS -> WeightUnit.LBS;
            case WEIGHT_KG ->  WeightUnit.KG;
            default -> throw new IllegalArgumentException(String.format(UNKNOWN_WEIGHT_UNIT_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}
