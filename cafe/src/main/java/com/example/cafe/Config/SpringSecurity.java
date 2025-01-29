package com.example.cafe.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Public endpoints
                        .anyRequest().authenticated()             // Protect all other endpoints
                )
                .formLogin(Customizer.withDefaults())         // Enable default login form
                .httpBasic(Customizer.withDefaults());        // Enable HTTP Basic authentication

        return http.build();
    }
}
