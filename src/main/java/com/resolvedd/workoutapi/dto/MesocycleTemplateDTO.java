package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MesocycleTemplateDTO (

        Long id,
        Long mesocycleId,
        Long workoutTemplateId,

        @NotNull(message = "Mesocycle template week number is required!")
        @Positive(message = "Mesocycle template week must be a positive number!")
        Integer weekNumber,

        @NotNull(message = "Mesocycle template day number is required!")
        @Min(value = 1, message = "Mesocycle day number must be at least 1!")
        @Max(value = 7, message = "Mesocycle day number cannot exceed 7!")
        Integer dayNumber
) {}
