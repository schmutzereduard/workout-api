package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.DTOUtils;
import com.resolvedd.workoutapi.dto.WorkoutSessionDTO;
import com.resolvedd.workoutapi.model.SessionExercise;
import com.resolvedd.workoutapi.model.WorkoutSession;
import com.resolvedd.workoutapi.repository.SessionExerciseRepository;
import com.resolvedd.workoutapi.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {

    private final WorkoutSessionRepository workoutSessionRepository;
    private final SessionExerciseRepository sessionExerciseRepository;

    public List<WorkoutSessionDTO> findAll() {
        return workoutSessionRepository
                .findAll()
                .stream()
                .map(DTOUtils::convertToDTO)
                .collect(Collectors.toList());
    }

    public WorkoutSession save(WorkoutSession workoutSession) {
        return workoutSessionRepository.save(workoutSession);
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(id).orElse(null);
        if (workoutSession != null) {
            //  Delete associated SessionExercises
            List<SessionExercise> sessionExercises = sessionExerciseRepository.findAllByWorkoutSession(workoutSession);
            for (SessionExercise sessionExercise : sessionExercises) {
                sessionExerciseRepository.deleteById(sessionExercise.getId()); //  Use SessionExerciseService to handle WorkingSet deletion
            }

            //  Remove reference (probably not needed with cascading but good practice)
            workoutSession.setSessionExercises(null);

            //  Delete the WorkoutSession
            workoutSessionRepository.deleteById(id);
        }
    }
}