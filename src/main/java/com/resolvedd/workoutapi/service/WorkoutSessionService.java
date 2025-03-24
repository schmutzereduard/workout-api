package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.WorkoutSession;
import com.resolvedd.workoutapi.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {

    private final WorkoutSessionRepository workoutSessionRepository;

    public List<WorkoutSession> findAll() {
        return workoutSessionRepository.findAll();
    }

    public WorkoutSession save(WorkoutSession workoutSession) {
        return workoutSessionRepository.save(workoutSession);
    }

    public void deleteById(Long id) {
        workoutSessionRepository.deleteById(id);
    }
}
