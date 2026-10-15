package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserInfoDTO (

        SyncMetadata metadata,

        @NotBlank(message = "First name cannot be empty!")
        String firstName,

        @NotBlank(message = "Last name cannot be empty!")
        String lastName,

        @NotBlank(message = "Gender cannot be empty!")
        @Pattern(regexp = "^[MF]$", message = "Gender must be either M (male) / F (female)!")
        String gender,

        @NotNull(message = "Date of birth cannot be empty!")
        @Past(message = "Date of birth cannot be in the future!")
        LocalDate dateOfBirth,

        @NotNull(message = "Height cannot be empty!")
        @Positive(message = "Height must be a positive number!")
        Integer heightInCm,

        @NotNull(message = "Weight cannot be empty!")
        @Positive(message = "Weight must be a positive number!")
        BigDecimal weightInKg
) {}