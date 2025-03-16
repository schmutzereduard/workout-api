package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.model.WorkingSet;
import com.resolvedd.workoutapi.service.WorkingSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/working-sets")
public class WorkingSetController {

    private final WorkingSetService workingSetService;

    @GetMapping("/{exerciseId}")
    public ResponseEntity<List<WorkingSet>> getSets(@PathVariable Long exerciseId) {
        return ResponseEntity.ok(workingSetService.findAllByExerciseId(exerciseId));
    }

    @PutMapping
    public ResponseEntity<WorkingSet> updateSet(@RequestBody WorkingSet workingSet) {
        return ResponseEntity.ok(workingSetService.save(workingSet));
    }

    @PostMapping
    public ResponseEntity<WorkingSet> addSet(@RequestBody WorkingSet workingSet) {
        return ResponseEntity.ok(workingSetService.save(workingSet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSet(@PathVariable Long id) {
        workingSetService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
