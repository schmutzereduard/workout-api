package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.WorkoutSessionDTO;
import com.resolvedd.workoutapi.model.WorkoutSession;
import com.resolvedd.workoutapi.service.WorkoutSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions")
public class WorkoutSessionController {

    private final WorkoutSessionService workoutSessionService;

    @GetMapping
    public ResponseEntity<List<WorkoutSessionDTO>> getWorkoutSessions() {
        return ResponseEntity.ok(workoutSessionService.findAll());
    }

    @PostMapping
    public ResponseEntity<WorkoutSession> addWorkoutSession(@RequestBody WorkoutSession workoutSession) {
        return ResponseEntity.ok(workoutSessionService.save(workoutSession));
    }

    @PutMapping
    public ResponseEntity<WorkoutSession> updateWorkoutSession(@RequestBody WorkoutSession workoutSession) {
        return ResponseEntity.ok(workoutSessionService.save(workoutSession));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWorkoutSessions(@RequestBody List<Long> ids) {
        workoutSessionService.deleteAllById(ids);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutSession(@RequestParam Long id) {
        workoutSessionService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
