package com.resolvedd.workoutapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record WorkoutExerciseDTO (

        Long id,

        @NotNull(message = "Exercise order within the workout is required!")
        @Positive(message = "Exercise order number must be positive!")
        Integer orderInWorkout,

        @NotNull(message = "Target sets is required!")
        @Positive(message = "Target sets number must be positive!")
        Integer targetSets,

        @NotNull(message = "Minimum target repetitions is required!")
        @Positive(message = "Minimum target repetitions number must be positive!")
        Integer targetRepetitionsMin,

        @NotNull(message = "Maximum target repetitions is required!")
        @Positive(message = "Maximum target repetitions number must be positive!")
        Integer targetRepetitionsMax,

        @Size(max = 255, message = "WorkoutExercise notes cannot be greater than 255 characters!")
        String notes,

        @Valid
        List<ExerciseSetDTO> exerciseSets
) {

    public WorkoutExerciseDTO {
        if (targetRepetitionsMax < targetRepetitionsMin) {
            throw new IllegalArgumentException("Maximum target repetitions cannot be less than minimum target repetitions!");
        }
    }

}