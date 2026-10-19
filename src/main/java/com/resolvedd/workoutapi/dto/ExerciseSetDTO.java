package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ExerciseSetDTO(

        Long id,

        @NotNull(message = "Set number is required!")
        @Positive(message = "Set number must be a positive number!")
        Integer setNumber,

        @NotNull(message = "Set weight is required!")
        @PositiveOrZero(message = "Set weight number must be a positive number!")
        BigDecimal weight,

        @NotNull(message = "Set target repetitions is required!")
        @PositiveOrZero(message = "Set target repetitions number must be a positive number!")
        Integer targetRepetitions,

        @NotNull(message = "Set actual repetitions is required!")
        @PositiveOrZero(message = "Set actual repetitions number must be a positive number!")
        Integer actualRepetitions,

        Integer repetitionsInReserve,

        Boolean isCompleted
) {
        public ExerciseSetDTO {
                isCompleted = actualRepetitions >= targetRepetitions;
        }
}