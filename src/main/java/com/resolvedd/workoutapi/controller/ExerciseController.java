package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.model.Exercise;
import com.resolvedd.workoutapi.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> getExercises() {
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @PutMapping
    public ResponseEntity<Exercise> updateExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.ok(exerciseService.save(exercise));
    }

    @PostMapping
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise) {

        return ResponseEntity.ok(exerciseService.save(exercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
