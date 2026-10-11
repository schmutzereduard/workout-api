package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = "Mesocycle transfer object representing a training block")
public class MesocycleDTO {

    @Schema(description = "Unique identifier of the mesocycle", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = MESOCYCLE_NAME_VALIDATION)
    @Schema(description = "Name of the mesocycle training block", example = "Hypertrophy Block 1", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotNull(message = MESOCYCLE_TARGET_WEEKS_VALIDATION)
    @Min(1)
    @Schema(description = "Target duration in weeks", example = "4", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer targetWeeks;

    @Schema(description = "Start date of the mesocycle", example = "2026-06-01")
    private LocalDate startDate;

    @Schema(description = "End date of the mesocycle", example = "2026-06-28")
    private LocalDate endDate;

    @NotBlank(message = MESOCYCLE_STATUS_VALIDATION)
    @Pattern(regexp = "^[IAC]$", message = MESOCYCLE_STATUS_VALIDATION2)
    @Schema(description = "Status of the mesocycle ('I' = Inactive, 'A' = Active, 'C' = Completed)", example = "A", requiredMode = Schema.RequiredMode.REQUIRED)
    private String status;
}