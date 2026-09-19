package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.WorkoutDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workouts")
public class WorkoutController {

    private final AuthService authService;
    private final WorkoutService workoutService;

    @GetMapping
    public ResponseEntity<List<WorkoutDTO>> getWorkouts(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(workoutService.findAllByUserId(authService.isAuthorized(token)));
    }

    @PostMapping
    public ResponseEntity<WorkoutDTO> addWorkout(@RequestBody WorkoutDTO workoutDTO) {
        return ResponseEntity.ok(workoutService.save(workoutDTO));
    }

    @PutMapping
    public ResponseEntity<WorkoutDTO> updateWorkout(@RequestBody WorkoutDTO workoutDTO) {
        return ResponseEntity.ok(workoutService.save(workoutDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkouts(@RequestBody List<Long> ids) {
        workoutService.deleteAllById(ids);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@RequestParam Long id) {
        workoutService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
