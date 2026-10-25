package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserInfoDTO (

        SyncMetadata metadata,

        @NotBlank(message = "First name is required!")
        @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters!")
        String firstName,

        @NotBlank(message = "Last name is required!")
        @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters!")
        String lastName,

        @NotBlank(message = "Gender is required!")
        @Pattern(regexp = "^[MF]$", message = "Gender must be either M (male) / F (female)!")
        String gender,

        @NotNull(message = "Date of birth is required!")
        @Past(message = "Date of birth cannot be in the future!")
        LocalDate dateOfBirth,

        @NotNull(message = "Height is required!")
        @Positive(message = "Height must be a positive number!")
        Integer heightInCm,

        @NotNull(message = "Weight is required!")
        @Positive(message = "Weight must be a positive number!")
        BigDecimal weightInKg
) {}