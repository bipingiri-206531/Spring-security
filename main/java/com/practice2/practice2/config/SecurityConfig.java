package com.practice2.practice2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http.csrf(c-> c.disable())
                .authorizeHttpRequests(request -> request
                                .requestMatchers("/himal/**").permitAll()
                                .requestMatchers("/users/**").permitAll()
                                .requestMatchers("/dipak/**").hasRole("DIPAK")
                                .requestMatchers("/sitaram/**").hasRole("SITARAM")
                                .requestMatchers("/bipin/read**").hasAuthority("read")
                                .requestMatchers("/bipin/write**").hasAuthority("write")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
