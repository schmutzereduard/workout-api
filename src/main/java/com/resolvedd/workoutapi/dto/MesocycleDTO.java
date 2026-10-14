package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = MESOCYCLE_SCHEMA_DESCRIPTION)
public class MesocycleDTO {

    @Schema(
            description = MESOCYCLE_SCHEMA_ID_DESCRIPTION,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = MESOCYCLE_NAME_VALIDATION)
    @Schema(
            description = MESOCYCLE_SCHEMA_NAME_DESCRIPTION,
            example = MESOCYCLE_SCHEMA_NAME_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String name;

    @NotNull(message = MESOCYCLE_TARGET_WEEKS_VALIDATION)
    @Min(1)
    @Schema(
            description = MESOCYCLE_SCHEMA_TARGET_WEEKS_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer targetWeeks;

    @Schema(
            description = MESOCYCLE_SCHEMA_START_DATE_DESCRIPTION,
            example = MESOCYCLE_SCHEMA_START_DATE_EXAMPLE
    )
    private LocalDate startDate;

    @Schema(
            description = MESOCYCLE_SCHEMA_END_DATE_DESCRIPTION,
            example = MESOCYCLE_SCHEMA_END_DATE_EXAMPLE
    )
    private LocalDate endDate;

    @Schema(
            description = MESOCYCLE_SCHEMA_WORKOUT_TEMPLATES_DESCRIPTION
    )
    private List<WorkoutTemplateDTO> workoutTemplates;
}