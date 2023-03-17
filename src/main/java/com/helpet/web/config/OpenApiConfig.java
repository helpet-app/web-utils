package com.helpet.web.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class OpenApiConfig {
    @ConditionalOnMissingBean
    @Bean
    public OpenAPI openAPI() {
        String securitySchemeName = "Bearer Authentication";

        SecurityRequirement securityRequirement = new SecurityRequirement().addList(securitySchemeName);

        Components components = new Components().addSecuritySchemes(securitySchemeName,
                                                                    new SecurityScheme()
                                                                            .name(securitySchemeName)
                                                                            .type(SecurityScheme.Type.HTTP)
                                                                            .scheme("bearer")
                                                                            .bearerFormat("JWT"));

        return new OpenAPI()
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}
