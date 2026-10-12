package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.WORKOUT_EXERCISE_VALIDATION;
import static com.resolvedd.workoutapi.constants.ValidationConstants.WORKOUT_EXERCISE_VALIDATION2;

@Data
@Schema(description = WORKOUT_EXERCISE_SCHEMA_DESCRIPTION)
public class WorkoutExerciseDTO {

    @Schema(
            description = WORKOUT_EXERCISE_SCHEMA_ID_DESCRIPTION,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = WORKOUT_EXERCISE_SCHEMA_EXERCISE_DESCRIPTION
    )
    private ExerciseDTO exercise;

    @NotNull(message = WORKOUT_EXERCISE_VALIDATION)
    @Positive(message = WORKOUT_EXERCISE_VALIDATION2)
    @Schema(
            description = WORKOUT_EXERCISE_SCHEMA_ORDER_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private int order;

    @Schema(
            description = WORKOUT_EXERCISE_SCHEMA_NOTES_DESCRIPTION,
            example = WORKOUT_EXERCISE_SCHEMA_NOTES_EXAMPLE
    )
    private String notes;

    @Schema(
            description = WORKOUT_EXERCISE_SCHEMA_SETS_DESCRIPTION
    )
    private List<ExerciseSetDTO> sets;
}