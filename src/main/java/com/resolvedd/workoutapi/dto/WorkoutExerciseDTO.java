package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ValidationConstants.WORKOUT_EXERCISE_VALIDATION;
import static com.resolvedd.workoutapi.constants.ValidationConstants.WORKOUT_EXERCISE_VALIDATION2;

@Data
public class WorkoutExerciseDTO {

    private Long id;

    private ExerciseDTO exercise;

    @NotNull(message = WORKOUT_EXERCISE_VALIDATION)
    @Positive(message = WORKOUT_EXERCISE_VALIDATION2)
    private int order;

    private String notes;
    private List<ExerciseSetDTO> sets;
}
