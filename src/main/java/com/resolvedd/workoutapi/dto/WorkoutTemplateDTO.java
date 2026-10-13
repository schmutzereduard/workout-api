package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = WORKOUT_TEMPLATE_SCHEMA_DESCRIPTION)
public class WorkoutTemplateDTO {

    @Schema(
            description = WORKOUT_TEMPLATE_SCHEMA_ID_DESCRIPTION,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = WORKOUT_TEMPLATE_SCHEMA_MESOCYCLE_ID_DESCRIPTION
    )
    private Long mesocycleId;

    @NotBlank(message = WORKOUT_NAME_VALIDATION)
    @Schema(
            description = WORKOUT_TEMPLATE_SCHEMA_NAME_DESCRIPTION,
            example = WORKOUT_TEMPLATE_SCHEMA_NAME_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String name;

    @NotNull(message = WORKOUT_DAY_ORDER_VALIDATION)
    @Min(1)
    @Schema(
            description = WORKOUT_TEMPLATE_SCHEMA_DAY_ORDER_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer dayOrder;

    @NotNull(message = WORKOUT_WEEK_NUMBER_VALIDATION)
    @Min(1)
    @Schema(
            description = WORKOUT_TEMPLATE_SCHEMA_WEEK_NUMBER_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer weekNumber;

    @Schema(
            description = WORKOUT_TEMPLATE_SCHEMA_TEMPLATE_EXERCISES_DESCRIPTION
    )
    private List<TemplateExerciseDTO> templateExercises;
}