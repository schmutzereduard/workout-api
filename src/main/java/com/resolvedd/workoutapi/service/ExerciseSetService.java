package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.mapper.ExerciseSetMapper;
import com.resolvedd.workoutapi.repository.ExerciseSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;
    private final ExerciseSetMapper exerciseSetMapper;
}