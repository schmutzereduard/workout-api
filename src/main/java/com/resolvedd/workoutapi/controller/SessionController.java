package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.model.Session;
import com.resolvedd.workoutapi.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    public ResponseEntity<List<Session>> getSessions() {
        return ResponseEntity.ok(sessionService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Session> addSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.save(session));
    }

    @PutMapping("/edit")
    public ResponseEntity<Session> updateSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.save(session));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@RequestParam Long id) {
        sessionService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
