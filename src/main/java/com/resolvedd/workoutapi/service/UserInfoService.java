package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.UserInfoDTO;
import com.resolvedd.workoutapi.exception.UserInfoNotFoundException;
import com.resolvedd.workoutapi.mapper.UserInfoMapper;
import com.resolvedd.workoutapi.model.UserInfo;
import com.resolvedd.workoutapi.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.USER_INFO_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapper userInfoMapper;

    public UserInfoDTO findByUserId(Long userId) {
        return userInfoRepository.findByUserId(userId).map(userInfoMapper::toDTO).orElseThrow(() -> new UserInfoNotFoundException(String.format(USER_INFO_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT, userId)));
    }

    @Transactional
    public UserInfoDTO save(Long userId, UserInfoDTO userInfoDTO) {

        UserInfo userInfo = userInfoMapper.toEntity(userInfoDTO);
        userInfo.setUserId(userId);
        userInfoRepository.save(userInfo);

        return userInfoMapper.toDTO(userInfo);
    }

    @Transactional
    public void deleteById(Long userInfoId) {
        userInfoRepository.deleteById(userInfoId);
    }
}
