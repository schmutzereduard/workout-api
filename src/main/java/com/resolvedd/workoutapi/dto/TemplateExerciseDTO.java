package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = TEMPLATE_EXERCISE_SCHEMA_DESCRIPTION)
public class TemplateExerciseDTO {

    @Schema(
            description = TEMPLATE_EXERCISE_SCHEMA_ID_DESCRIPTION,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(description = TEMPLATE_EXERCISE_SCHEMA_WORKOUT_TEMPLATE_ID_DESCRIPTION)
    private Long workoutTemplateId;

    @Schema(description = TEMPLATE_EXERCISE_SCHEMA_EXERCISE_ID_DESCRIPTION)
    private Long exerciseId;

    @NotNull(message = EXERCISE_ORDER_VALIDATION)
    @Positive(message = EXERCISE_ORDER_VALIDATION2)
    @Schema(
            description = TEMPLATE_EXERCISE_SCHEMA_EXERCISE_ORDER_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer exerciseOrder;

    @NotNull(message = TARGET_SETS_VALIDATION)
    @Positive(message = TARGET_SETS_VALIDATION2)
    @Schema(
            description = TEMPLATE_EXERCISE_SCHEMA_TARGET_SETS_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer targetSets;

    @NotNull(message = TARGET_REPETITIONS_MIN_VALIDATION)
    @Min(1)
    @Schema(
            description = TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MIN_DESCRIPTION,
            example = TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MIN_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer targetRepetitionsMin;

    @NotNull(message = TARGET_REPETITIONS_MAX_VALIDATION)
    @Positive(message = TARGET_REPETITIONS_MAX_VALIDATION2)
    @Schema(
            description = TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MAX_DESCRIPTION,
            example = TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MAX_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer targetRepetitionsMax;
}