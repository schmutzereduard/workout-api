package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.EXERCISE_NAME_VALIDATION;

@Data
@Schema(description = EXERCISE_DTO_SCHEMA_DESCRIPTION)
public class ExerciseDTO {

    @Schema(
            description = EXERCISE_DTO_SCHEMA_ID_DESCRIPTION,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = EXERCISE_NAME_VALIDATION)
    @Schema(
            description = EXERCISE_DTO_SCHEMA_NAME_DESCRIPTION,
            example = EXERCISE_DTO_SCHEMA_NAME_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String name;

    @Schema(
            description = EXERCISE_DTO_SCHEMA_CUES_DESCRIPTION,
            example = EXERCISE_DTO_SCHEMA_CUES_EXAMPLE
    )
    private String cues;
}
