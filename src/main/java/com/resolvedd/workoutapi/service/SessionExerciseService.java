package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.SessionExercise;
import com.resolvedd.workoutapi.model.WorkingSet;
import com.resolvedd.workoutapi.repository.SessionExerciseRepository;
import com.resolvedd.workoutapi.repository.WorkingSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionExerciseService {

    private final SessionExerciseRepository sessionExerciseRepository;
    private final WorkingSetRepository workingSetRepository;

    public SessionExercise findById(Long id) {
        return sessionExerciseRepository.findById(id).orElse(null);
    }

    public SessionExercise save(SessionExercise sessionExercise) {
        return sessionExerciseRepository.save(sessionExercise);
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        SessionExercise sessionExercise = sessionExerciseRepository.findById(id).orElse(null);
        if (sessionExercise != null) {
            //  Delete associated WorkingSets
            List<WorkingSet> workingSets = workingSetRepository.findAllBySessionExercise(sessionExercise);
            workingSetRepository.deleteAll(workingSets);  //  Use the JpaRepository's deleteAll

            //  Remove references to avoid FK constraint violations (probably not needed with cascading, but good practice)
            sessionExercise.setWorkoutSession(null);
            sessionExercise.setWorkoutExercise(null);
            sessionExercise.setWorkingSets(null);

            //  Delete the SessionExercise
            sessionExerciseRepository.deleteById(id);
        }
    }
}