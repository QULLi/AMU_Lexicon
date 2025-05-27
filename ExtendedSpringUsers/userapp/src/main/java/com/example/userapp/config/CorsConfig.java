
package com.example.userapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Global CORS configuration for the application.
 *
 * This configuration allows cross-origin requests from http://localhost:4200,
 * which is typically used for local frontend development (e.g., Angular).
 *
 * If you deploy your frontend to a different domain, update the allowedOrigins accordingly.
 */
@Configuration
public class CorsConfig {

    /**
     * Configures CORS mappings for the entire application.
     *
     * @return a WebMvcConfigurer with the specified CORS settings
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow all endpoints to be accessed from the specified origin with common HTTP methods
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
