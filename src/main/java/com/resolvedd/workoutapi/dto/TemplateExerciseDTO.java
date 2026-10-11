package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = "Template exercise transfer object linking an exercise to a workout template with target sets and reps")
public class TemplateExerciseDTO {

    @Schema(description = "Unique identifier of the template exercise", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "ID of the parent workout template", example = "5")
    private Long workoutTemplateId;

    @Schema(description = "ID of the associated exercise", example = "12")
    private Long exerciseId;

    @NotNull(message = EXERCISE_ORDER_VALIDATION)
    @Positive(message = EXERCISE_ORDER_VALIDATION2)
    @Schema(description = "Order sequence of the exercise in the template", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer exerciseOrder;

    @NotNull(message = TARGET_SETS_VALIDATION)
    @Positive(message = TARGET_SETS_VALIDATION2)
    @Schema(description = "Target number of sets", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer targetSets;

    @NotNull(message = TARGET_REPETITIONS_MIN_VALIDATION)
    @Min(1)
    @Schema(description = "Minimum target repetitions per set", example = "8", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer targetRepetitionsMin;

    @NotNull(message = TARGET_REPETITIONS_MAX_VALIDATION)
    @Positive(message = TARGET_REPETITIONS_MAX_VALIDATION2)
    @Schema(description = "Maximum target repetitions per set", example = "12", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer targetRepetitionsMax;
}