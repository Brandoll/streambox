// src/main/java/com/example/utp1/config/CorsConfig.java
package com.example.streambox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Aplica a todos los endpoints que comiencen con /api
                .allowedOrigins("*") // Permitir todos los orígenes
                .allowedMethods("*") // Permitir todos los métodos
                .allowedHeaders("*"); // Permitir todos los encabezados
    }
}
