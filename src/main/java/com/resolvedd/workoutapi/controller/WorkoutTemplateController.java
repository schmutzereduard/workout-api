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

import static com.resolvedd.workoutapi.constants.ControllerConstants.WORKOUT_TEMPLATE_CONTROLLER_REQUEST_MAPPING;
import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(WORKOUT_TEMPLATE_CONTROLLER_REQUEST_MAPPING)
@Tag(
        name = WORKOUT_TEMPLATE_CONTROLLER_TAG_NAME,
        description = WORKOUT_TEMPLATE_CONTROLLER_TAG_DESCRIPTION
)
@SecurityRequirement(name = SECURITY_SCHEME_NAME)
public class WorkoutTemplateController {

    private final AuthService authService;
    private final WorkoutTemplateService workoutTemplateService;

    @Operation(
            summary = WORKOUT_TEMPLATE_CONTROLLER_GET_WORKOUT_TEMPLATES_OPERATION_SUMMARY,
            description = WORKOUT_TEMPLATE_CONTROLLER_GET_WORKOUT_TEMPLATES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = WORKOUT_TEMPLATE_CONTROLLER_GET_WORKOUT_TEMPLATES_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, array = @ArraySchema(schema = @Schema(implementation = WorkoutTemplateDTO.class)))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @GetMapping("/{id}")
    public ResponseEntity<List<WorkoutTemplateDTO>> getWorkoutTemplates(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long mesocycleId
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(workoutTemplateService.findAllByMesocycleId(mesocycleId));
    }

    @Operation(
            summary = WORKOUT_TEMPLATE_CONTROLLER_PUT_WORKOUT_TEMPLATE_OPERATION_SUMMARY,
            description = WORKOUT_TEMPLATE_CONTROLLER_PUT_WORKOUT_TEMPLATE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = WORKOUT_TEMPLATE_CONTROLLER_PUT_WORKOUT_TEMPLATE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = WorkoutTemplateDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PutMapping
    public ResponseEntity<WorkoutTemplateDTO> updateWorkoutTemplate(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutTemplateDTO workoutTemplateDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(workoutTemplateService.save(workoutTemplateDTO));
    }

    @Operation(
            summary = WORKOUT_TEMPLATE_CONTROLLER_POST_WORKOUT_TEMPLATE_OPERATION_SUMMARY,
            description = WORKOUT_TEMPLATE_CONTROLLER_POST_WORKOUT_TEMPLATE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_CREATED,
            description = WORKOUT_TEMPLATE_CONTROLLER_POST_WORKOUT_TEMPLATE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = WorkoutTemplateDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PostMapping
    public ResponseEntity<WorkoutTemplateDTO> addWorkoutTemplate(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutTemplateDTO workoutTemplateDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutTemplateService.save(workoutTemplateDTO));
    }

    @Operation(
            summary = WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATES_OPERATION_SUMMARY,
            description = WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATES_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @DeleteMapping
    public ResponseEntity<Void> deleteWorkoutTemplates(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        workoutTemplateService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATE_OPERATION_SUMMARY,
            description = WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATE_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
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