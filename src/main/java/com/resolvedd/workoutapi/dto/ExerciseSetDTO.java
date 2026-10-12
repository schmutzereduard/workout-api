package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @NotNull(message = EXERCISE_SET_ACTUAL_REP_VALIDATION)
    @PositiveOrZero(message = EXERCISE_SET_ACTUAL_REP_VALIDATION2)
    @Schema(
            description = EXERCISE_SET_ACTUAL_REPETITIONS_DESCRIPTION,
            example = EXERCISE_SET_ACTUAL_REPETITIONS_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer actualRepetitions;
}