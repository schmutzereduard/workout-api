package com.resolvedd.workoutapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record MesocycleDTO(

        SyncMetadata metadata,

        @NotBlank(message = "Mesocycle name cannot be empty!")
        String name,

        @NotNull(message = "Mesocycle target weeks is required!")
        @Positive(message = "Mesocycle target weeks must be a positive number!")
        Integer targetWeeks,

        @NotNull(message = "Mesocycle deload week is required!")
        @Positive(message = "Mesocycle target weeks must be a positive number!")
        Integer deloadWeek,

        @NotNull(message = "Mesocycle startDate is required!")
        LocalDate startDate,

        @NotNull(message = "Mesocycle endDate is required!")
        LocalDate endDate,

        @Valid
        List<MesocycleTemplateDTO> mesocycleTemplates
) {
    public MesocycleDTO {
        if (endDate().isBefore(startDate)) {
            throw new IllegalArgumentException("Mesocycle end date must be after start date");
        }
        if (deloadWeek > targetWeeks) {
            throw new IllegalArgumentException("Mesocycle deload week must be within target weeks");
        }
    }
}