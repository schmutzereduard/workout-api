package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.ExerciseSetDTO;
import com.resolvedd.workoutapi.mapper.ExerciseSetMapper;
import com.resolvedd.workoutapi.model.ExerciseSet;
import com.resolvedd.workoutapi.repository.ExerciseSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;
    private final ExerciseSetMapper exerciseSetMapper;

    public List<ExerciseSetDTO> findAll() {
        return exerciseSetRepository.findAll()
                .stream()
                .map(exerciseSetMapper::toDTO)
                .toList();
    }

    public ExerciseSetDTO save(ExerciseSetDTO exerciseSetDTO) {
        ExerciseSet exerciseSet = exerciseSetRepository.save(exerciseSetMapper.toEntity(exerciseSetDTO));
        return exerciseSetMapper.toDTO(exerciseSet);
    }

    public void deleteAllById(List<Long> ids) {
        exerciseSetRepository.deleteAllById(ids);
    }

    public void deleteById(Long id) {
        exerciseSetRepository.deleteById(id);
    }
}