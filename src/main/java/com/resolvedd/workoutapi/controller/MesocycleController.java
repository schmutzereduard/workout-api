package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.MesocycleDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.MesocycleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workout/mesocycles")
@Tag(name = "Mesocycles Management", description = "Endpoints for managing user's training mesocycles")
@SecurityRequirement(name = "bearerAuth")
public class MesocycleController {

    private final AuthService authService;
    private final MesocycleService mesocycleService;

    @Operation(summary = "Get all user's mesocycles", description = "Retrieves a list of all training mesocycles belonging to the authenticated user.")
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved list",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MesocycleDTO.class)))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @GetMapping
    public ResponseEntity<List<MesocycleDTO>> getMesocycles(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(mesocycleService.findAllByUserId(authService.isAuthorized(token)));
    }

    @Operation(summary = "Update a mesocycle", description = "Updates an existing training mesocycle for the authenticated user.")
    @ApiResponse(
            responseCode = "200",
            description = "Mesocycle updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MesocycleDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PutMapping
    public ResponseEntity<MesocycleDTO> updateMesocycle(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody MesocycleDTO mesocycleDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(mesocycleService.save(userId, mesocycleDTO));
    }

    @Operation(summary = "Create a new mesocycle", description = "Registers a new training mesocycle for the authenticated user.")
    @ApiResponse(
            responseCode = "201",
            description = "Mesocycle created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MesocycleDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PostMapping
    public ResponseEntity<MesocycleDTO> addMesocycle(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody MesocycleDTO mesocycleDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(mesocycleService.save(userId, mesocycleDTO));
    }

    @Operation(summary = "Delete multiple mesocycles", description = "Deletes a batch of training mesocycles by their IDs.")
    @ApiResponse(responseCode = "204", description = "Mesocycles deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping
    public ResponseEntity<Void> deleteMesocycles(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        mesocycleService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a mesocycle by ID", description = "Deletes a specific training mesocycle using its unique identifier.")
    @ApiResponse(responseCode = "204", description = "Mesocycle deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesocycle(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        mesocycleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}