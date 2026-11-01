package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

import static com.resolvedd.workoutapi.constants.WorkoutConstants.WEIGHT_KG;

public record UserPreferencesDTO(

        @NotNull(message = "Sync metadata is required!")
        SyncMetadata metadata,

        @Pattern(regexp = "^(lbs|kg)$", message = "Weight unit can be either lbs / kg!")
        String weightUnit,

        @Positive(message = "Progressive Overload Increment must be a positive number!")
        BigDecimal progressiveOverloadIncrement,

        @Min(value = 1, message = "Volume percentage reduction cannot be lower than 1%!")
        @Max(value = 100, message = "Volume percentage reduction cannot be higher than 100%")
        Integer deloadVolumePercentage,

        @Min(value = 1, message = "Intensity percentage reduction cannot be lower than 1%!")
        @Max(value = 100, message = "Intensity percentage reduction cannot be higher than 100%")
        Integer deloadIntensityPercentage,

        @Size(min = 7, max = 7, message = "Color code must be 7 characters long!")
        String backgroundColor,

        @Size(min = 7, max = 7, message = "Color code must be 7 characters long!")
        String accentColor
) {
    public UserPreferencesDTO {
        if (weightUnit == null) {
            weightUnit = WEIGHT_KG;
        }

        if (progressiveOverloadIncrement == null) {
            progressiveOverloadIncrement = BigDecimal.valueOf(2.5);
        }

        if (deloadVolumePercentage == null) {
            deloadVolumePercentage = 30;
        }

        if (deloadIntensityPercentage == null) {
            deloadIntensityPercentage = 10;
        }

        if (backgroundColor == null) {
            backgroundColor = "#121212";
        }

        if (accentColor == null) {
            accentColor = "#FF0000";
        }
    }
}
