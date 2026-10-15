package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.MesocycleDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.MesocycleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ControllerConstants.MESOCYCLE_CONTROLLER_REQUEST_MAPPING;

@RestController
@RequiredArgsConstructor
@RequestMapping(MESOCYCLE_CONTROLLER_REQUEST_MAPPING)
public class MesocycleController {

    private final AuthService authService;
    private final MesocycleService mesocycleService;

    @GetMapping
    public ResponseEntity<List<MesocycleDTO>> getMesocycles(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return ResponseEntity.ok(mesocycleService.findAllByUserId(authService.isAuthorized(token)));
    }

    @PutMapping
    public ResponseEntity<MesocycleDTO> updateMesocycle(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody MesocycleDTO mesocycleDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.ok(mesocycleService.save(userId, mesocycleDTO));
    }

    @PostMapping
    public ResponseEntity<MesocycleDTO> addMesocycle(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody MesocycleDTO mesocycleDTO
    ) {
        Long userId = authService.isAuthorized(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(mesocycleService.save(userId, mesocycleDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMesocycles(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody List<Long> ids
    ) {
        authService.isAuthorized(token);
        mesocycleService.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesocycle(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        mesocycleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}