package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.TemplateExerciseDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.TemplateExerciseService;
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
@RequestMapping("/api/workout/templateExercises")
@Tag(name = "Template Exercises Management", description = "Endpoints for managing template exercises")
@SecurityRequirement(name = "bearerAuth")
public class TemplateExerciseController {

    private final AuthService authService;
    private final TemplateExerciseService templateExerciseService;

    @Operation(summary = "Get all template exercises", description = "Retrieves a list of all template exercises.")
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved list",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TemplateExerciseDTO.class)))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @GetMapping
    public ResponseEntity<List<TemplateExerciseDTO>> getTemplateExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(templateExerciseService.findAll());
    }

    @Operation(summary = "Update a template exercise", description = "Updates an existing template exercise.")
    @ApiResponse(
            responseCode = "200",
            description = "Template exercise updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateExerciseDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PutMapping
    public ResponseEntity<TemplateExerciseDTO> updateTemplateExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody TemplateExerciseDTO templateExerciseDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(templateExerciseService.save(templateExerciseDTO));
    }

    @Operation(summary = "Create a new template exercise", description = "Registers a new template exercise.")
    @ApiResponse(
            responseCode = "201",
            description = "Template exercise created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemplateExerciseDTO.class))
    )
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @PostMapping
    public ResponseEntity<TemplateExerciseDTO> addTemplateExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody TemplateExerciseDTO templateExerciseDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(templateExerciseService.save(templateExerciseDTO));
    }

    @Operation(summary = "Delete multiple template exercises", description = "Deletes a batch of template exercises by their IDs.")
    @ApiResponse(responseCode = "204", description = "Template exercises deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping
    public ResponseEntity<Void> deleteTemplateExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        templateExerciseService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a template exercise by ID", description = "Deletes a specific template exercise using its unique identifier.")
    @ApiResponse(responseCode = "204", description = "Template exercise deleted successfully", content = @Content)
    @ApiResponse(responseCode = "401", description = "User is not authorized", content = @Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplateExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        templateExerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}