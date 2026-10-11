package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.ExerciseDTO;
import com.resolvedd.workoutapi.mapper.ExerciseMapper;
import com.resolvedd.workoutapi.model.Exercise;
import com.resolvedd.workoutapi.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public List<ExerciseDTO> findAll() {
        return exerciseRepository.findAll().stream()
                .map(exerciseMapper::toDTO)
                .toList();
    }

    public List<ExerciseDTO> findAllByUserId(Long userId) {
        return exerciseRepository.findAllByUserId(userId)
                .stream()
                .map(exerciseMapper::toDTO)
                .toList();
    }

    @Transactional
    public ExerciseDTO save(Long userId, ExerciseDTO exerciseDTO) {
        Exercise exercise = exerciseMapper.toEntity(exerciseDTO);
        exercise.setUserId(userId);
        return exerciseMapper.toDTO(exerciseRepository.save(exercise));
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        exerciseRepository.deleteAllById(ids);
    }

    @Transactional
    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }
}
