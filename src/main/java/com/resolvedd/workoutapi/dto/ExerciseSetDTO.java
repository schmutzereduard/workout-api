package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = "Exercise set transfer object")
public class ExerciseSetDTO {

    @Schema(description = "Unique set identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = EXERCISE_SET_NUMBER_VALIDATION)
    @Positive(message = EXERCISE_SET_NUMBER_VALIDATION2)
    @Schema(description = "Set number in the sequence", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer setNumber;

    @NotNull(message = EXERCISE_SET_WEIGHT_VALIDATION)
    @PositiveOrZero(message = EXERCISE_SET_WEIGHT_VALIDATION2)
    @Schema(description = "Weight used for the set", example = "100.5", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal weight;

    @NotNull(message = EXERCISE_SET_ACTUAL_REP_VALIDATION)
    @PositiveOrZero(message = EXERCISE_SET_ACTUAL_REP_VALIDATION2)
    @Schema(description = "Actual repetitions performed", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer actualRepetitions;
}