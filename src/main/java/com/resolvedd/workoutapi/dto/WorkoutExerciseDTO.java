package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ValidationConstants.WORKOUT_EXERCISE_VALIDATION;
import static com.resolvedd.workoutapi.constants.ValidationConstants.WORKOUT_EXERCISE_VALIDATION2;

@Data
@Schema(description = "Workout exercise transfer object linking an exercise, its sequence, notes, and performed sets to a workout session")
public class WorkoutExerciseDTO {

    @Schema(description = "Unique identifier of the workout exercise record", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Details of the underlying exercise being performed")
    private ExerciseDTO exercise;

    @NotNull(message = WORKOUT_EXERCISE_VALIDATION)
    @Positive(message = WORKOUT_EXERCISE_VALIDATION2)
    @Schema(description = "Order sequence of this exercise within the workout", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int order;

    @Schema(description = "Optional notes specific to this exercise instance", example = "Felt great, maintained strict form.")
    private String notes;

    @Schema(description = "List of sets completed for this exercise")
    private List<ExerciseSetDTO> sets;
}