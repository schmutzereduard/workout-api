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

import static com.resolvedd.workoutapi.constants.ControllerConstants.TEMPLATE_EXERCISE_CONTROLLER_REQUEST_MAPPING;
import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(TEMPLATE_EXERCISE_CONTROLLER_REQUEST_MAPPING)
@Tag(
        name = TEMPLATE_EXERCISE_CONTROLLER_TAG_NAME,
        description = TEMPLATE_EXERCISE_CONTROLLER_TAG_DESCRIPTION
)
@SecurityRequirement(name = SECURITY_SCHEME_NAME)
public class TemplateExerciseController {

    private final AuthService authService;
    private final TemplateExerciseService templateExerciseService;

    @Operation(
            summary = TEMPLATE_EXERCISE_CONTROLLER_GET_TEMPLATE_EXERCISES_OPERATION_SUMMARY,
            description = TEMPLATE_EXERCISE_CONTROLLER_GET_TEMPLATE_EXERCISES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = TEMPLATE_EXERCISE_CONTROLLER_GET_TEMPLATE_EXERCISES_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, array = @ArraySchema(schema = @Schema(implementation = TemplateExerciseDTO.class)))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @GetMapping("/{id}")
    public ResponseEntity<List<TemplateExerciseDTO>> getTemplateExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(templateExerciseService.findAllByTemplateId(id));
    }

    @Operation(
            summary = TEMPLATE_EXERCISE_CONTROLLER_UPDATE_TEMPLATE_EXERCISE_OPERATION_SUMMARY,
            description = TEMPLATE_EXERCISE_CONTROLLER_UPDATE_TEMPLATE_EXERCISE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = TEMPLATE_EXERCISE_CONTROLLER_UPDATE_TEMPLATE_EXERCISE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = TemplateExerciseDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PutMapping
    public ResponseEntity<TemplateExerciseDTO> updateTemplateExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody TemplateExerciseDTO templateExerciseDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(templateExerciseService.save(templateExerciseDTO));
    }

    @Operation(
            summary = TEMPLATE_EXERCISE_CONTROLLER_CREATE_TEMPLATE_EXERCISE_OPERATION_SUMMARY,
            description = TEMPLATE_EXERCISE_CONTROLLER_CREATE_TEMPLATE_EXERCISE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_CREATED,
            description = TEMPLATE_EXERCISE_CONTROLLER_CREATE_TEMPLATE_EXERCISE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = TemplateExerciseDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PostMapping
    public ResponseEntity<TemplateExerciseDTO> addTemplateExercise(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody TemplateExerciseDTO templateExerciseDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(templateExerciseService.save(templateExerciseDTO));
    }

    @Operation(
            summary = TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISES_OPERATION_SUMMARY,
            description = TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_CREATED,
            description = TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISES_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @DeleteMapping
    public ResponseEntity<Void> deleteTemplateExercises(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        templateExerciseService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISE_OPERATION_SUMMARY,
            description = TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_CREATED,
            description = TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISE_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
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