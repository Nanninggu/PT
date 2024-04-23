package com.example.HexagonalArchitecture.adapter.config;

import com.example.HexagonalArchitecture.domain.UserRepository;
import com.example.HexagonalArchitecture.Infrastructure.PostgresUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserRepository userRepository() {
        return new PostgresUserRepository();
    }

}
