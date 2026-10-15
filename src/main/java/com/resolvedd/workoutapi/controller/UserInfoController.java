package com.resolvedd.workoutapi.controller;

import com.resolvedd.workoutapi.dto.UserInfoDTO;
import com.resolvedd.workoutapi.service.AuthService;
import com.resolvedd.workoutapi.service.UserInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.resolvedd.workoutapi.constants.ControllerConstants.USER_INFO_CONTROLLER_REQUEST_MAPPING;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_INFO_CONTROLLER_REQUEST_MAPPING)
public class UserInfoController {

    private final AuthService authService;
    private final UserInfoService userInfoService;

    @GetMapping
    public ResponseEntity<UserInfoDTO> getUserInfo(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return ResponseEntity.ok(userInfoService.findByUserId(authService.isAuthorized(token)));
    }

    @PutMapping
    public ResponseEntity<UserInfoDTO> updateUserInfo(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody UserInfoDTO userInfoDTO
    ) {
        return ResponseEntity.ok(userInfoService.save(authService.isAuthorized(token), userInfoDTO));
    }

    @PostMapping
    public ResponseEntity<UserInfoDTO> createUserInfo(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @Valid @RequestBody UserInfoDTO userInfoDTO
    ) {
        return ResponseEntity.ok(userInfoService.save(authService.isAuthorized(token), userInfoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserInfo(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @PathVariable Long id
    ) {
        authService.isAuthorized(token);
        userInfoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}