package com.example.HexagonalArchitecture.adapter.config;

import com.example.HexagonalArchitecture.domain.PostgresRepository;
import com.example.HexagonalArchitecture.Infrastructure.PostgresRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PostgresRepository userRepository() {
        return new PostgresRepositoryImpl();
    }

}
