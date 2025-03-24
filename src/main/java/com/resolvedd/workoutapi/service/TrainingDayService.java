package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.TrainingDay;
import com.resolvedd.workoutapi.repository.TrainingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingDayService {

    private final TrainingDayRepository trainingDayRepository;

    public List<TrainingDay> findAll() {
        return trainingDayRepository.findAll();
    }

    public TrainingDay save(TrainingDay trainingDay) {
        return trainingDayRepository.save(trainingDay);
    }

    public void deleteById(Long id) {
        trainingDayRepository.deleteById(id);
    }
}
