package com.resolvedd.workoutapi.model.converter;

import com.resolvedd.workoutapi.exception.UnknownMesocycleStatusException;
import com.resolvedd.workoutapi.model.MesocycleStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_MESOCYCLE_STATUS_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.*;

@Converter(autoApply = true)
public class MesocycleStatusConverter implements AttributeConverter<MesocycleStatus, String> {

    @Override
    public String convertToDatabaseColumn(MesocycleStatus status) {
        if (status == null) return null;
        return status.getValue();
    }

    @Override
    public MesocycleStatus convertToEntityAttribute(String value) {
        if (value == null) return null;
        return switch (value) {
            case MESOCYCLE_INACTIVE_STATUS -> MesocycleStatus.INACTIVE;
            case MESOCYCLE_ACTIVE_STATUS -> MesocycleStatus.ACTIVE;
            case MESOCYCLE_COMPLETED_STATUS -> MesocycleStatus.COMPLETED;
            default -> throw new UnknownMesocycleStatusException(String.format(UNKNOWN_MESOCYCLE_STATUS_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}