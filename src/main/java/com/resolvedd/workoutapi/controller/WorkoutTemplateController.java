package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.WorkoutTemplateDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.WorkoutTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ControllerConstants.WORKOUT_TEMPLATE_CONTROLLER_REQUEST_MAPPING;

@RestController
@RequiredArgsConstructor
@RequestMapping(WORKOUT_TEMPLATE_CONTROLLER_REQUEST_MAPPING)
public class WorkoutTemplateController {

    private final AuthService authService;
    private final WorkoutTemplateService workoutTemplateService;

    @GetMapping("/{id}")
    public ResponseEntity<List<WorkoutTemplateDTO>> getWorkoutTemplates(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long mesocycleId
    ) {
        return ResponseEntity.ok(workoutTemplateService.findAllWorkoutTemplates(authService.isAuthorized(token)));
    }

    @PutMapping
    public ResponseEntity<WorkoutTemplateDTO> updateWorkoutTemplate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutTemplateDTO workoutTemplateDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.ok(workoutTemplateService.save(workoutTemplateDTO));
    }

    @PostMapping
    public ResponseEntity<WorkoutTemplateDTO> addWorkoutTemplate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutTemplateDTO workoutTemplateDTO
    ) {
        authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutTemplateService.save(workoutTemplateDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkoutTemplates(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        workoutTemplateService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutTemplate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        workoutTemplateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}