package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import static com.resolvedd.workoutapi.constants.ValidationConstants.EXERCISE_NAME_VALIDATION;

@Data
@Schema(description = "Exercise transfer object")
public class ExerciseDTO {

    @Schema(description = "Unique exercise identifier")
    private Long id;

    @NotBlank(message = EXERCISE_NAME_VALIDATION)
    @Schema(description = "Exercise name", example = "Barbell Bench Press", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Exercise cues", example = "Elbows tucked")
    private String cues;
}
