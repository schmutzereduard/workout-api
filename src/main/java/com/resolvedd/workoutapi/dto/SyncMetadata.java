package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record SyncMetadata (

        Long id,

        @NotBlank(message = "Client id is required")
        String clientId,

        LocalDateTime createdAt,

        LocalDateTime updatedAt,

        LocalDateTime deletedAt
){}
