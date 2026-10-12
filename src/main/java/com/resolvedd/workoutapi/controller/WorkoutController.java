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

import static com.resolvedd.workoutapi.constants.ControllerConstants.WORKOUT_CONTROLLER_REQUEST_MAPPING;
import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(WORKOUT_CONTROLLER_REQUEST_MAPPING)
@Tag(
        name = WORKOUT_CONTROLLER_TAG_NAME,
        description = WORKOUT_CONTROLLER_TAG_DESCRIPTION
)
@SecurityRequirement(name = SECURITY_SCHEME_NAME)
public class WorkoutController {

    private final AuthService authService;
    private final WorkoutService workoutService;

    @Operation(
            summary = WORKOUT_CONTROLLER_GET_WORKOUTS_OPERATION_SUMMARY,
            description = WORKOUT_CONTROLLER_GET_WORKOUTS_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = WORKOUT_CONTROLLER_GET_WORKOUTS_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, array = @ArraySchema(schema = @Schema(implementation = WorkoutDTO.class)))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @GetMapping
    public ResponseEntity<List<WorkoutDTO>> getWorkouts(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(workoutService.findAllByUserId(authService.isAuthorized(token)));
    }

    @Operation(
            summary = WORKOUT_CONTROLLER_PUT_WORKOUT_OPERATION_SUMMARY,
            description = WORKOUT_CONTROLLER_PUT_WORKOUT_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_CREATED,
            description = WORKOUT_CONTROLLER_PUT_WORKOUT_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = WorkoutDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PostMapping
    public ResponseEntity<WorkoutDTO> addWorkout(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutDTO workoutDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutService.save(userId, workoutDTO));
    }

    @Operation(
            summary = WORKOUT_CONTROLLER_POST_WORKOUT_OPERATION_SUMMARY,
            description = WORKOUT_CONTROLLER_POST_WORKOUT_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = WORKOUT_CONTROLLER_POST_WORKOUT_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = WorkoutDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PutMapping
    public ResponseEntity<WorkoutDTO> updateWorkout(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutDTO workoutDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(workoutService.save(userId, workoutDTO));
    }

    @Operation(
            summary = WORKOUT_CONTROLLER_DELETE_WORKOUTS_OPERATION_SUMMARY,
            description = WORKOUT_CONTROLLER_DELETE_WORKOUTS_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = WORKOUT_CONTROLLER_DELETE_WORKOUTS_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @DeleteMapping
    public ResponseEntity<Void> deleteWorkouts(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        workoutService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = WORKOUT_CONTROLLER_DELETE_WORKOUT_OPERATION_SUMMARY,
            description = WORKOUT_CONTROLLER_DELETe_WORKOUT_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = WORKOUT_CONTROLLER_DELETE_WORKOUT_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
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