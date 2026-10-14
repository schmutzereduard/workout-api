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

import static com.resolvedd.workoutapi.constants.ControllerConstants.MESOCYCLE_CONTROLLER_REQUEST_MAPPING;
import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MESOCYCLE_CONTROLLER_REQUEST_MAPPING)
@Tag(
        name = MESOCYCLE_CONTROLLER_TAG_NAME,
        description = MESOCYCLE_CONTROLLER_TAG_DESCRIPTION
)
@SecurityRequirement(name = SECURITY_SCHEME_NAME)
public class MesocycleController {

    private final AuthService authService;
    private final MesocycleService mesocycleService;

    @Operation(
            summary = MESOCYCLE_CONTROLLER_GET_MESOCYCLES_OPERATION_SUMMARY,
            description = MESOCYCLE_CONTROLLER_GET_MESOCYCLES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = MESOCYCLE_CONTROLLER_GET_MESOCYCLES_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, array = @ArraySchema(schema = @Schema(implementation = MesocycleDTO.class)))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @GetMapping
    public ResponseEntity<List<MesocycleDTO>> getMesocycles(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(mesocycleService.findAllByUserId(authService.isAuthorized(token)));
    }

    @Operation(
            summary = MESOCYCLE_CONTROLLER_UPDATE_MESOCYCLE_OPERATION_SUMMARY,
            description = MESOCYCLE_CONTROLLER_UPDATE_MESOCYCLE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_OK,
            description = MESOCYCLE_CONTROLLER_UPDATE_MESOCYCLE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = MesocycleDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PutMapping
    public ResponseEntity<MesocycleDTO> updateMesocycle(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody MesocycleDTO mesocycleDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(mesocycleService.save(userId, mesocycleDTO));
    }

    @Operation(
            summary = MESOCYCLE_CONTROLLER_CREATE_MESOCYCLE_OPERATION_SUMMARY,
            description = MESOCYCLE_CONTROLLER_CREATE_MESOCYCLE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_CREATED,
            description = MESOCYCLE_CONTROLLER_CREATE_MESOCYCLE_OK_DESCRIPTION,
            content = @Content(mediaType = JSON_MEDIA_TYPE, schema = @Schema(implementation = MesocycleDTO.class))
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @PostMapping
    public ResponseEntity<MesocycleDTO> addMesocycle(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody MesocycleDTO mesocycleDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(mesocycleService.save(userId, mesocycleDTO));
    }

    @Operation(
            summary = MESOCYCLE_CONTROLLER_DELETE_MESOCYCLES_OPERATION_SUMMARY,
            description = MESOCYCLE_CONTROLLER_DELETE_MESOCYCLES_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = MESOCYCLE_CONTROLLER_DELETE_MESOCYCLES_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
    @DeleteMapping
    public ResponseEntity<Void> deleteMesocycles(
            @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        mesocycleService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = MESOCYCLE_CONTROLLER_DELETE_MESOCYCLE_OPERATION_SUMMARY,
            description = MESOCYCLE_CONTROLLER_DELETE_MESOCYCLE_OPERATION_DESCRIPTION
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_NO_CONTENT,
            description = MESOCYCLE_CONTROLLER_DELETE_MESOCYCLE_OK_DESCRIPTION,
            content = @Content
    )
    @ApiResponse(
            responseCode = RESPONSE_CODE_UNAUTHORIZED,
            description = RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION,
            content = @Content
    )
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