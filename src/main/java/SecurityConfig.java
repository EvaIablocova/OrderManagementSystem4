package org.example.ordermanagementsystem2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//Spring сам делает бины Singleton, так что @Configuration уже Singleton.
@Configuration
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);


    public SecurityConfig() {
        logger.info("⚡ SecurityConfig Singleton created");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Разрешить доступ ко всем запросам
                )
                .csrf(csrf -> csrf.disable()); // Отключить CSRF для упрощения

        return http.build();
    }
}
