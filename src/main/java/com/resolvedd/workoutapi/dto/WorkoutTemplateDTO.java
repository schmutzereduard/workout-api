package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = "Workout template transfer object representing a planned workout routine within a mesocycle")
public class WorkoutTemplateDTO {

    @Schema(description = "Unique identifier of the workout template", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "ID of the parent mesocycle training block", example = "3")
    private Long mesocycleId;

    @NotBlank(message = WORKOUT_NAME_VALIDATION)
    @Schema(description = "Name of the workout template", example = "Leg Day A", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotNull(message = WORKOUT_DAY_ORDER_VALIDATION)
    @Min(1)
    @Schema(description = "Day order sequence within the mesocycle", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer dayOrder;

    @Schema(description = "List of template exercises included in this routine")
    private List<TemplateExerciseDTO> templateExercises;
}