package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.model.Workout;
import com.resolvedd.workoutapi.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping
    public ResponseEntity<List<Workout>> getWorkouts() {
        return ResponseEntity.ok(workoutService.findAll());
    }

    @PostMapping
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {
        return ResponseEntity.ok(workoutService.save(workout));
    }

    @PutMapping
    public ResponseEntity<Workout> updateWorkout(@RequestBody Workout workout) {
        return ResponseEntity.ok(workoutService.save(workout));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@RequestParam Long id) {
        workoutService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
