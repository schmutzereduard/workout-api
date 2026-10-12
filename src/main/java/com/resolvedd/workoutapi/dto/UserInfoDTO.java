package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;
import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = USER_INFO_SCHEMA_DESCRIPTION)
public class UserInfoDTO {

    @NotBlank(message = FIRST_NAME_VALIDATION)
    @Schema(
            description = USER_INFO_SCHEMA_FIRST_NAME_DESCRIPTION,
            example = USER_INFO_SCHEMA_FIRST_NAME_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String firstName;

    @NotBlank(message = LAST_NAME_VALIDATION)
    @Schema(
            description = USER_INFO_SCHEMA_LAST_NAME_DESCRIPTION,
            example = USER_INFO_SCHEMA_LAST_NAME_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String lastName;

    @NotBlank(message = GENDER_VALIDATION)
    @Pattern(regexp = "^[MF]$", message = GENDER_VALIDATION2)
    @Schema(
            description = USER_INFO_SCHEMA_GENDER_DESCRIPTION,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String gender;

    @NotNull(message = DATE_OF_BIRTH_VALIDATION)
    @Schema(
            description = USER_INFO_SCHEMA_DATE_OF_BIRTH_DESCRIPTION,
            example = USER_INFO_SCHEMA_DATE_OF_BIRTH_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private LocalDate dateOfBirth;

    @NotNull(message = HEIGHT_VALIDATION)
    @Positive(message = HEIGHT_VALIDATION2)
    @Schema(
            description = USER_INFO_SCHEMA_HEIGHT_IN_CM_DESCRIPTION,
            example = USER_INFO_SCHEMA_HEIGHT_IN_CM_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer heightInCm;

    @NotNull(message = WEIGHT_VALIDATION)
    @Positive(message = WEIGHT_VALIDATION2)
    @Schema(
            description = USER_INFO_SCHEMA_WEIGHT_IN_KG_DESCRIPTION,
            example = USER_INFO_SCHEMA_WEIGHT_IN_KG_EXAMPLE,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BigDecimal weightInKg;
}