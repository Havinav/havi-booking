package com.havi.busbooking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
<<<<<<< HEAD
                .allowedOrigins("http://localhost:5173","https://havibus.netlify.app") // Specific origin
=======
                .allowedOrigins("http://localhost:5173","") // Specific origin
>>>>>>> 25e017cedb7c893c4c4de5571df215836756b255
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}