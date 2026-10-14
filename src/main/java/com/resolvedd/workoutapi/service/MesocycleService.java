package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.MesocycleDTO;
import com.resolvedd.workoutapi.mapper.MesocycleMapper;
import com.resolvedd.workoutapi.model.Mesocycle;
import com.resolvedd.workoutapi.repository.MesocycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesocycleService {

    private final MesocycleRepository mesocycleRepository;
    private final MesocycleMapper mesocycleMapper;

    public List<MesocycleDTO> findAllByUserId(Long userId) {
        return mesocycleRepository.findAllByUserId(userId).stream()
                .map(mesocycleMapper::toDTO)
                .toList();
    }

    @Transactional
    public MesocycleDTO save(Long userId, MesocycleDTO mesocycleDTO) {
        Mesocycle mesocycle = mesocycleMapper.toEntity(mesocycleDTO);
        mesocycle.setUserId(userId);
        return mesocycleMapper.toDTO(mesocycleRepository.save(mesocycle));
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        mesocycleRepository.deleteAllById(ids);
    }

    @Transactional
    public void deleteById(Long id) {
        mesocycleRepository.deleteById(id);
    }
}
