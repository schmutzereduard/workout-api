package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.constants.AuthConstants;
import com.resolvedd.workoutapi.exception.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final WebClient webClient;

    public Long isAuthorized(String token) {

        try {
            return webClient.get()
                    .uri(AuthConstants.AUTHORIZED_ENDPOINT)
                    .header(HttpHeaders.AUTHORIZATION, token)
                    .retrieve()
                    .bodyToMono(Long.class)
                    .block();
        } catch (Exception e) {
            throw new AuthException(e);
        }
    }
}
