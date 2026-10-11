package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = "Workout transfer object representing a completed or logged training session")
public class WorkoutDTO {

    @Schema(description = "Unique identifier of the workout", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = WORKOUT_NAME_VALIDATION)
    @Schema(description = "Name of the workout session", example = "Upper Body Strength", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotNull(message = WORKOUT_DATE_VALIDATION)
    @Schema(description = "Date and time when the workout took place", example = "2026-06-15T10:30:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime date;

    @Size(max = 255, message = WORKOUT_NOTES_VALIDATION)
    @Schema(description = "Optional notes or comments about the workout session", example = "Felt strong, hit a PR on bench press.")
    private String notes;

    @Schema(description = "List of exercises performed during this workout session")
    private List<WorkoutExerciseDTO> exercises;
}