package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SyncMetadata (

        Long id,

        @NotNull(message = "User id is required!")
        Long userId,

        @NotBlank(message = "Client id is required")
        String clientId,

        LocalDateTime createdAt,

        LocalDateTime updatedAt,

        LocalDateTime deletedAt
){}
