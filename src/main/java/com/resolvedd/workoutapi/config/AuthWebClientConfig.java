package com.resolvedd.workoutapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AuthWebClientConfig {

    @Value("${auth-service.base-url}")
    private String baseUrl;

    @Bean
    public WebClient authWebClient() {
        return WebClient.builder().baseUrl(baseUrl).build();
    }
}