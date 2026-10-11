package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.WorkoutTemplateDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.WorkoutTemplateService;
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
@RequestMapping("/api/workout/workoutTemplates")
@Tag(name = "Workout Templates Management", description = "Endpoints for managing user's workout templates")
@SecurityRequirement(name = "bearerAuth")
public class WorkoutTemplateController {

    private final AuthService authService;
    private final WorkoutTemplateService workoutTemplateService;

    @Operation(summary = "Get all workout templates from a mesocycle", description = "Retrieves a list of all workout templates belonging to a mesocycle.")
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved list",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = WorkoutTemplateDTO.class)))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @GetMapping("/{id}")
    public ResponseEntity<List<WorkoutTemplateDTO>> getWorkoutTemplates(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long mesocycleId
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(workoutTemplateService.findAllByMesocycleId(mesocycleId));
    }

    @Operation(summary = "Update a workout template", description = "Updates an existing workout template for the authenticated user.")
    @ApiResponse(
            responseCode = "200",
            description = "Workout template updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = WorkoutTemplateDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PutMapping
    public ResponseEntity<WorkoutTemplateDTO> updateWorkoutTemplate(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutTemplateDTO workoutTemplateDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(workoutTemplateService.save(workoutTemplateDTO));
    }

    @Operation(summary = "Create a new workout template", description = "Registers a new workout template for the authenticated user.")
    @ApiResponse(
            responseCode = "201",
            description = "Workout template created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = WorkoutTemplateDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PostMapping
    public ResponseEntity<WorkoutTemplateDTO> addWorkoutTemplate(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutTemplateDTO workoutTemplateDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutTemplateService.save(workoutTemplateDTO));
    }

    @Operation(summary = "Delete multiple workout templates", description = "Deletes a batch of workout templates by their IDs.")
    @ApiResponse(responseCode = "204", description = "Workout templates deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping
    public ResponseEntity<Void> deleteWorkoutTemplates(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        workoutTemplateService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a workout template by ID", description = "Deletes a specific workout template using its unique identifier.")
    @ApiResponse(responseCode = "204", description = "Workout template deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutTemplate(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        workoutTemplateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}