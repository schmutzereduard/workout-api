package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.model.Muscle;
import com.resolvedd.workoutapi.service.MuscleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/muscles")
public class MuscleController {

    private final MuscleService muscleService;

    @GetMapping
    public ResponseEntity<List<Muscle>> getMuscles() {
        return ResponseEntity.ok(muscleService.findAll());
    }

    @PutMapping
    public ResponseEntity<Muscle> updateMuscle(@RequestBody Muscle muscle) {
        return ResponseEntity.ok(muscleService.save(muscle));
    }

    @PostMapping
    public ResponseEntity<Muscle> addMuscle(@RequestBody Muscle muscle) {
        return ResponseEntity.ok(muscleService.save(muscle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMuscle(@PathVariable Long id) {
        muscleService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
