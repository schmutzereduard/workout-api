package com.resolvedd.workoutapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

import static com.resolvedd.workoutapi.constants.OpenApiConstants.*;

@Configuration
@OpenAPIDefinition(
    info = @Info(
            title = INFO_TITLE,
            version = INFO_VERSION,
            description = INFO_DESCRIPTION
    )
)
@SecurityScheme(
    name = SECURITY_SCHEME_NAME,
    type = SecuritySchemeType.HTTP,
    scheme = SECURITY_SCHEME,
    bearerFormat = SECURITY_SCHEME_FORMAT,
    description = SECURITY_SCHEME_DESCRIPTION
)
public class OpenApiConfig {
}