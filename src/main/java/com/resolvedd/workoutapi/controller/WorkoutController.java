package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.WorkoutDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.WorkoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ControllerConstants.WORKOUT_CONTROLLER_REQUEST_MAPPING;

@RestController
@RequiredArgsConstructor
@RequestMapping(WORKOUT_CONTROLLER_REQUEST_MAPPING)
public class WorkoutController {

    private final AuthService authService;
    private final WorkoutService workoutService;

    @GetMapping
    public ResponseEntity<List<WorkoutDTO>> getWorkouts(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return ResponseEntity.ok(workoutService.findAllByUserId(authService.isAuthorized(token)));
    }

    @PostMapping
    public ResponseEntity<WorkoutDTO> addWorkout(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutDTO workoutDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutService.save(userId, workoutDTO));
    }

    @PutMapping
    public ResponseEntity<WorkoutDTO> updateWorkout(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody WorkoutDTO workoutDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(workoutService.save(userId, workoutDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkouts(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        workoutService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        workoutService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}