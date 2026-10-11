package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.ExerciseDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.ExerciseService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workout/exercises")
@Tag(name = "Exercises Management", description = "Endpoints for managing user's exercises")
@SecurityRequirement(name = "bearerAuth")
public class ExerciseController {

    private final AuthService authService;
    private final ExerciseService exerciseService;

    @Operation(summary = "Get all user's exercises", description = "Retrieves a list of all exercises belonging to the authenticated user.")
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved list",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ExerciseDTO.class)))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> getExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(exerciseService.findAllByUserId(authService.isAuthorized(token)));
    }

    @Operation(summary = "Update an exercise", description = "Updates an existing exercise for the authenticated user.")
    @ApiResponse(responseCode = "200", description = "Exercise updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExerciseDTO.class)))
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PutMapping
    public ResponseEntity<ExerciseDTO> updateExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody ExerciseDTO exerciseDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(exerciseService.save(userId, exerciseDTO));
    }

    @Operation(summary = "Create a new exercise", description = "Registers a new exercise for the authenticated user.")
    @ApiResponse(
            responseCode = "201",
            description = "Exercise created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExerciseDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PostMapping
    public ResponseEntity<ExerciseDTO> addExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody ExerciseDTO exerciseDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(201).body(exerciseService.save(userId, exerciseDTO));
    }

    @Operation(summary = "Delete multiple exercises", description = "Deletes a batch of exercises by their IDs.")
    @ApiResponse(responseCode = "204", description = "Exercises deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping
    public ResponseEntity<Void> deleteExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        exerciseService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete an exercise by ID", description = "Deletes a specific exercise using its unique identifier.")
    @ApiResponse(responseCode = "204", description = "Exercise deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        exerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}