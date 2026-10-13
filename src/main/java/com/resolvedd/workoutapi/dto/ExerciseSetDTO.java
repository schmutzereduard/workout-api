package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = EXERCISE_SET_SCHEMA_DESCRIPTION)
public class ExerciseSetDTO {

    @Schema(
            description = EXERCISE_SET_SCHEMA_ID_DESCRIPTION,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotNull(message = EXERCISE_SET_NUMBER_VALIDATION)
    @Positive(message = EXERCISE_SET_NUMBER_VALIDATION2)
    @Schema(
            description = EXERCISE_SET_SCHEMA_SET_NUMBER_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer setNumber;

    @NotNull(message = EXERCISE_SET_WEIGHT_VALIDATION)
    @PositiveOrZero(message = EXERCISE_SET_WEIGHT_VALIDATION2)
    @Schema(
            description = EXERCISE_SET_SCHEMA_WEIGHT_DESCRIPTION,
            example = EXERCISE_SET_SCHEMA_WEIGHT_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BigDecimal weight;

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

    @NotNull(message = EXERCISE_SET_ACTUAL_REP_VALIDATION)
    @PositiveOrZero(message = EXERCISE_SET_ACTUAL_REP_VALIDATION2)
    @Schema(
            description = EXERCISE_SET_ACTUAL_REPETITIONS_DESCRIPTION,
            example = EXERCISE_SET_ACTUAL_REPETITIONS_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer actualRepetitions;
}