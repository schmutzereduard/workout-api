package com.resolvedd.workoutapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record WorkoutExerciseDTO (

        Long id,

        @NotNull(message = "Exercise order in the workout is required!")
        @Positive(message = "Exercise order must be a positive number!")
        Integer orderInWorkout,

        @NotNull(message = "Target sets is required!")
        @Positive(message = "Target sets must be a positive number!")
        Integer targetSets,

        @NotNull(message = "Min target repetitions is required!")
        @Positive(message = "Min target repetitions must be a positive number!")
        Integer targetRepetitionsMin,

        @NotNull(message = "Max target repetitions is required!")
        @Positive(message = "Max target repetitions must be a positive number!")
        Integer targetRepetitionsMax,

        @Size(max = 255, message = "Exercise notes must be 255 characters max!")
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