package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.Set;
import com.resolvedd.workoutapi.repository.SetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SetService {

    private final SetRepository setRepository;

    public List<Set> findAllByExerciseId(Long id) {
        return setRepository.findAllByExerciseId(id);
    }

    public Set save(Set set) {
        return setRepository.save(set);
    }

    public void deleteById(Long id) {
        setRepository.deleteById(id);
    }
}
