package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
public class ExerciseSetDTO {

    private Long id;

    @NotNull(message = EXERCISE_SET_NUMBER_VALIDATION)
    @Positive(message = EXERCISE_SET_NUMBER_VALIDATION2)
    private int setNumber;

    @NotNull(message = EXERCISE_SET_WEIGHT_VALIDATION)
    @PositiveOrZero(message = EXERCISE_SET_WEIGHT_VALIDATION2)
    private BigDecimal weight;

    @NotNull(message = EXERCISE_SET_TARGET_REP_VALIDATION)
    @Positive(message = EXERCISE_SET_TARGET_REP_VALIDATION2)
    private int targetRepetitions;

    @NotNull(message = EXERCISE_SET_ACTUAL_REP_VALIDATION)
    @PositiveOrZero(message = EXERCISE_SET_ACTUAL_REP_VALIDATION2)
    private int actualRepetitions;

    private boolean isCompleted;
}
