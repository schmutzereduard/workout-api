package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.model.Set;
import com.resolvedd.workoutapi.service.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sets")
public class SetController {

    private final SetService setService;

    @GetMapping("/{exerciseId}")
    public ResponseEntity<List<Set>> getSets(@PathVariable Long exerciseId) {
        return ResponseEntity.ok(setService.findAllByExerciseId(exerciseId));
    }

    @PutMapping
    public ResponseEntity<Set> updateSet(@RequestBody Set set) {
        return ResponseEntity.ok(setService.save(set));
    }

    @PostMapping
    public ResponseEntity<Set> addSet(@RequestBody Set set) {
        return ResponseEntity.ok(setService.save(set));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSet(@PathVariable Long id) {
        setService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
