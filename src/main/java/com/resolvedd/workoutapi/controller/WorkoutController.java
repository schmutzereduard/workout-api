package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.WorkoutDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.WorkoutService;
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
@RequestMapping("/api/workout/workouts")
@Tag(name = "Workouts Management", description = "Endpoints for managing user's workouts")
@SecurityRequirement(name = "bearerAuth")
public class WorkoutController {

    private final AuthService authService;
    private final WorkoutService workoutService;

    @Operation(summary = "Get all user's workouts", description = "Retrieves a list of all workouts belonging to the authenticated user.")
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved list",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = WorkoutDTO.class)))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @GetMapping
    public ResponseEntity<List<WorkoutDTO>> getWorkouts(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(workoutService.findAllByUserId(authService.isAuthorized(token)));
    }

    @Operation(summary = "Create a new workout", description = "Registers a new workout for the authenticated user.")
    @ApiResponse(
            responseCode = "201",
            description = "Workout created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = WorkoutDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PostMapping
    public ResponseEntity<WorkoutDTO> addWorkout(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutDTO workoutDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutService.save(userId, workoutDTO));
    }

    @Operation(summary = "Update a workout", description = "Updates an existing workout for the authenticated user.")
    @ApiResponse(
            responseCode = "200",
            description = "Workout updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = WorkoutDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PutMapping
    public ResponseEntity<WorkoutDTO> updateWorkout(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutDTO workoutDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(workoutService.save(userId, workoutDTO));
    }

    @Operation(summary = "Delete multiple workouts", description = "Deletes a batch of workouts by their IDs.")
    @ApiResponse(responseCode = "204", description = "Workouts deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping
    public ResponseEntity<Void> deleteWorkouts(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        workoutService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a workout by ID", description = "Deletes a specific workout using its unique identifier.")
    @ApiResponse(responseCode = "204", description = "Workout deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        workoutService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}