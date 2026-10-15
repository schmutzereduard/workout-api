package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TemplateExerciseDTO(

        Long id,

        @NotNull(message = "WorkoutTemplateId cannot be empty in TemplateExercise!")
        Long workoutTemplateId,

        @NotNull(message = "ExerciseId cannot be empty in TemplateExercise")
        Long exerciseId,

        @NotNull(message = "TemplateExercise order within the workout is required!")
        @Positive(message = "TemplateExercise order number must be positive!")
        Integer exerciseOrder,

        @NotNull(message = "TemplateExercise target sets is required!")
        @Positive(message = "TemplateExercise target sets number must be positive!")
        Integer targetSets,

        @NotNull(message = "Minimum TemplateExercise target repetitions is required!")
        @Min(value = 1, message = "Minimum TemplateExercise target repetitions must be at least 1!")
        Integer targetRepetitionsMin,

        @NotNull(message = "Maximum TemplateExercise target repetitions is required!")
        @Min(value = 1, message = "Maximum TemplateExercise target repetitions number must be at least 1!")
        Integer targetRepetitionsMax
) {

    public TemplateExerciseDTO {
        if (targetRepetitionsMax < targetRepetitionsMin) {
            throw new IllegalArgumentException("Maximum target repetitions cannot be less than minimum target repetitions!");
        }
    }
}