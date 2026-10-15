package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.ExerciseDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ControllerConstants.EXERCISE_CONTROLLER_REQUEST_MAPPING;

@RestController
@RequiredArgsConstructor
@RequestMapping(EXERCISE_CONTROLLER_REQUEST_MAPPING)
public class ExerciseController {

    private final AuthService authService;
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> getExercises(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return ResponseEntity.ok(exerciseService.findAllByUserId(authService.isAuthorized(token)));
    }

    @PutMapping
    public ResponseEntity<ExerciseDTO> updateExercise(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody ExerciseDTO exerciseDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(exerciseService.save(userId, exerciseDTO));
    }

    @PostMapping
    public ResponseEntity<ExerciseDTO> addExercise(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody ExerciseDTO exerciseDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(201).body(exerciseService.save(userId, exerciseDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteExercises(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        exerciseService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        exerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}