package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.Muscle;
import com.resolvedd.workoutapi.repository.MuscleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuscleService {

    private final MuscleRepository muscleRepository;

    public List<Muscle> findAll() {
        return muscleRepository.findAll();
    }

    public Muscle save(Muscle muscle) {
        return muscleRepository.save(muscle);
    }

    public void deleteById(Long id) {
        muscleRepository.deleteById(id);
    }
}
