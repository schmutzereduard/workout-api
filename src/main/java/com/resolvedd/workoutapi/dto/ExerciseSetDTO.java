package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ExerciseSetDTO (

        Long id,

        @NotNull(message = "ExerciseSet set number is required!")
        @Positive(message = "ExerciseSet set number must be positive!")
        Integer setNumber,

        @NotNull(message = "ExerciseSet weight is required!")
        @PositiveOrZero(message = "Exercise set weight number must be positive!")
        BigDecimal weight,

        @NotNull(message = "ExerciseSet actual repetitions is required!")
        @PositiveOrZero(message = "ExerciseSet actual repetitions number must be positive!")
        Integer actualRepetitions
) {}