package com.resolvedd.workoutapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
@Schema(description = "User information transfer object containing personal and physical details")
public class UserInfoDTO {

    @NotBlank(message = FIRST_NAME_VALIDATION)
    @Schema(description = "First name of the user", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @NotBlank(message = LAST_NAME_VALIDATION)
    @Schema(description = "Last name of the user", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @NotBlank(message = GENDER_VALIDATION)
    @Pattern(regexp = "^[MF]$", message = GENDER_VALIDATION2)
    @Schema(description = "Gender of the user ('M' = Male, 'F' = Female)", example = "M", requiredMode = Schema.RequiredMode.REQUIRED)
    private String gender;

    @NotNull(message = DATE_OF_BIRTH_VALIDATION)
    @Schema(description = "Date of birth of the user", example = "1995-05-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate dateOfBirth;

    @NotNull(message = HEIGHT_VALIDATION)
    @Positive(message = HEIGHT_VALIDATION2)
    @Schema(description = "Height of the user in centimeters", example = "180", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer heightInCm;

    @NotNull(message = WEIGHT_VALIDATION)
    @Positive(message = WEIGHT_VALIDATION2)
    @Schema(description = "Weight of the user in kilograms", example = "75.5", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal weightInKg;
}