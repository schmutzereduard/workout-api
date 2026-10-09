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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workout/exercises")
public class ExerciseController {

    private final AuthService authService;
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> getExercises(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
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
        return ResponseEntity.ok(exerciseService.save(userId, exerciseDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteExercises(@RequestBody List<Long> ids) {
        exerciseService.deleteAllById(ids);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
