package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = WORKOUT_SCHEMA_DESCRIPTION)
public class WorkoutDTO {

    @Schema(
            description = WORKOUT_SCHEMA_ID_DESCRIPTION,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = WORKOUT_NAME_VALIDATION)
    @Schema(
            description = WORKOUT_SCHEMA_NAME_DESCRIPTION,
            example = WORKOUT_SCHEMA_NAME_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String name;

    @NotNull(message = WORKOUT_DATE_VALIDATION)
    @Schema(
            description = WORKOUT_SCHEMA_DATE_DESCRIPTION,
            example = WORKOUT_SCHEMA_DATE_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private LocalDateTime date;

    @Size(max = 255, message = WORKOUT_NOTES_VALIDATION)
    @Schema(
            description = WORKOUT_SCHEMA_NOTES_DESCRIPTION,
            example = WORKOUT_SCHEMA_NOTES_EXAMPLE
    )
    private String notes;

    @Schema(
            description = WORKOUT_SCHEMA_EXERCISES_DESCRIPTION
    )
    private List<WorkoutExerciseDTO> exercises;
}