package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.ExerciseDTO;
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
    public ResponseEntity<List<ExerciseDTO>> getExercises() {
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @PutMapping
    public ResponseEntity<ExerciseDTO> updateExercise(@RequestBody ExerciseDTO exerciseDTO) {
        return ResponseEntity.ok(exerciseService.save(exerciseDTO));
    }

    @PostMapping
    public ResponseEntity<ExerciseDTO> addExercise(@RequestBody ExerciseDTO exerciseDTO) {

        return ResponseEntity.ok(exerciseService.save(exerciseDTO));
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
