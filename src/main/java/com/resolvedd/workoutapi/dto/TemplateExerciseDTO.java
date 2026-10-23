package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TemplateExerciseDTO(

        Long id,
        Long workoutTemplateId,
        Long exerciseId,

        @NotNull(message = "Exercise order in the workout is required!")
        @Positive(message = "Exercise order must be a positive number!")
        Integer exerciseOrder,

        @Positive(message = "Exercise warmup sets must be a positive number!")
        Integer warmupSets,

        @NotNull(message = "Exercise target sets is required!")
        @Positive(message = "Exercise target sets must be a positive number!")
        Integer targetSets,

        @NotNull(message = "Min target repetitions is required!")
        @Min(value = 1, message = "Min target repetitions must be at least 1!")
        Integer targetRepetitionsMin,

        @NotNull(message = "Max target repetitions is required!")
        @Min(value = 1, message = "Max target repetitions number must be at least 1!")
        Integer targetRepetitionsMax
) {

    public TemplateExerciseDTO {
        if (targetRepetitionsMax < targetRepetitionsMin) {
            throw new IllegalArgumentException("Max target repetitions cannot be less than min target repetitions!");
        }
    }
}