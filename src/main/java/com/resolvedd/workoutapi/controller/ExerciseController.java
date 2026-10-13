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

import static com.resolvedd.workoutapi.constants.ControllerConstants.EXERCISE_CONTROLLER_REQUEST_MAPPING;
import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EXERCISE_CONTROLLER_REQUEST_MAPPING)
@Tag(
        name = EXERCISE_CONTROLLER_TAG_NAME,
        description = EXERCISE_CONTROLLER_TAG_DESCRIPTION
)
@SecurityRequirement(name = SECURITY_SCHEME_NAME)
public class ExerciseController {

    private final AuthService authService;
    private final ExerciseService exerciseService;

    @Operation(
            summary = EXERCISE_CONTROLLER_GET_EXERCISES_OPERATION_SUMMARY,
            description = EXERCISE_CONTROLLER_GET_EXERCISES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = EXERCISE_CONTROLLER_GET_EXERCISES_OK_DESCRIPTION,
            content = @Content(
                    mediaType = JSON_MEDIA_TYPE,
                    array = @ArraySchema(schema = @Schema(implementation = ExerciseDTO.class))
            )
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> getExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(exerciseService.findAllByUserId(authService.isAuthorized(token)));
    }

    @Operation(
            summary = EXERCISE_CONTROLLER_UPDATE_EXERCISE_OPERATION_SUMMARY,
            description = EXERCISE_CONTROLLER_UPDATE_EXERCISE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = EXERCISE_CONTROLLER_UPDATE_EXERCISE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = ExerciseDTO.class)))
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PutMapping
    public ResponseEntity<ExerciseDTO> updateExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody ExerciseDTO exerciseDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(exerciseService.save(userId, exerciseDTO));
    }

    @Operation(
            summary = EXERCISE_CONTROLLER_CREATE_EXERCISE_OPERATION_SUMMARY,
            description = EXERCISE_CONTROLLER_CREATE_EXERCISE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_CREATED,
            description = EXERCISE_CONTROLLER_CREATE_EXERCISE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = ExerciseDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PostMapping
    public ResponseEntity<ExerciseDTO> addExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody ExerciseDTO exerciseDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(201).body(exerciseService.save(userId, exerciseDTO));
    }

    @Operation(
            summary = EXERCISE_CONTROLLER_DELETE_EXERCISES_OPERATION_SUMMARY,
            description = EXERCISE_CONTROLLER_DELETE_EXERCISES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = EXERCISE_CONTROLLER_DELETE_EXERCISES_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @DeleteMapping
    public ResponseEntity<Void> deleteExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        exerciseService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = EXERCISE_CONTROLLER_DELETE_EXERCISE_OPERATION_SUMMARY,
            description = EXERCISE_CONTROLLER_DELETE_EXERCISE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = EXERCISE_CONTROLLER_DELETE_EXERCISE_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
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