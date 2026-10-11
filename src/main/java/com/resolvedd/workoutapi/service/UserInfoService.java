package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.UserInfoDTO;
import com.resolvedd.workoutapi.exception.UserInfoNotFoundException;
import com.resolvedd.workoutapi.mapper.UserInfoMapper;
import com.resolvedd.workoutapi.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.USER_INFO_NOT_FOUND_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapper userInfoMapper;

    public UserInfoDTO findByUserId(Long userId) {
        return userInfoRepository.findByUserId(userId).map(userInfoMapper::toDTO).orElseThrow(() -> new UserInfoNotFoundException(String.format(USER_INFO_NOT_FOUND_EXCEPTION_MESSAGE, userId)));
    }
}
