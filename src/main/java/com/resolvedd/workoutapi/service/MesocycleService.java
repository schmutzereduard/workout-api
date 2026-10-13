package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.MesocycleDTO;
import com.resolvedd.workoutapi.exception.*;
import com.resolvedd.workoutapi.mapper.MesocycleMapper;
import com.resolvedd.workoutapi.model.Mesocycle;
import com.resolvedd.workoutapi.model.MesocycleStatus;
import com.resolvedd.workoutapi.repository.MesocycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.*;

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
    public MesocycleDTO startMesocycle(Long userId, Long mesocycleId) {

        if (!mesocycleRepository.findAllByUserIdAndStatus(userId, MesocycleStatus.ACTIVE).isEmpty()) {
            throw new MesocycleAlreadyInProgressException(MESOCYCLE_ALREADY_IN_PROGRESS_EXCEPTION_MESSAGE);
        }

        Mesocycle mesocycle = mesocycleRepository.findById(mesocycleId).orElseThrow(() -> new MesocycleNotFoundException(String.format(MESOCYCLE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT, mesocycleId)));
        if (mesocycle.getStatus().equals(MesocycleStatus.COMPLETED)) {
            throw new MesocycleAlreadyEndedException(String.format(MESOCYCLE_ALREADY_ENDED_EXCEPTION_FORMAT, mesocycle.getEndDate().toString()));
        }

        LocalDate start = LocalDate.now();
        mesocycle.setStartDate(start);
        mesocycle.setEndDate(start.plusWeeks(mesocycle.getTargetWeeks()));
        mesocycle.setStatus(MesocycleStatus.ACTIVE);

        mesocycleRepository.save(mesocycle);

        return mesocycleMapper.toDTO(mesocycle);
    }

    @Transactional
    public MesocycleDTO endMesocycle(Long mesocycleId) {

        Mesocycle mesocycle = mesocycleRepository.findById(mesocycleId).orElseThrow(() -> new MesocycleNotFoundException(String.format(MESOCYCLE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT, mesocycleId)));
        if (mesocycle.getStatus().equals(MesocycleStatus.COMPLETED)) {
            throw new MesocycleAlreadyEndedException(String.format(MESOCYCLE_ALREADY_ENDED_EXCEPTION_FORMAT, mesocycle.getEndDate().toString()));
        } else if (mesocycle.getStatus().equals(MesocycleStatus.INACTIVE)) {
            throw new MesocycleNotStartedException(MESOCYCLE_NOT_STARTED_EXCEPTION_MESSAGE);
        }

        mesocycle.setEndDate(LocalDate.now());
        mesocycle.setStatus(MesocycleStatus.COMPLETED);

        mesocycleRepository.save(mesocycle);

        return mesocycleMapper.toDTO(mesocycle);
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
