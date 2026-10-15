package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MesocycleTemplateDTO (

        Long id,

        @NotNull(message = "MesocycleTemplate mesocycleId is required!")
        Long mesocycleId,

        @NotNull(message = "MesocycleTemplate workoutTemplateId is required!")
        Long workoutTemplateId,

        @NotNull(message = "MesocycleTemplate week number is required!")
        @Positive(message = "MesocycleTemplate week number must be positive!")
        Integer weekNumber,

        @NotNull(message = "MesocycleTemplate day number is required!")
        @Min(value = 1, message = "Day number must be at least 1!")
        @Max(value = 7, message = "Day number cannot exceed 7!")
        Integer dayNumber
) {}
