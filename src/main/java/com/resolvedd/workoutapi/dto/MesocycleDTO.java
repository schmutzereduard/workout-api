package com.resolvedd.workoutapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record MesocycleDTO(

        SyncMetadata metadata,

        @NotBlank(message = "Mesocycle name cannot be empty!")
        String name,

        LocalDate startDate,

        LocalDate endDate,

        @Valid
        List<MesocycleTemplateDTO> mesocycleTemplates
) {
    public MesocycleDTO {
        if (startDate != null && endDate != null &&endDate().isBefore(startDate)) {
            throw new IllegalArgumentException("Mesocycle end date must be after start date");
        }
    }
}