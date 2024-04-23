package com.example.HexagonalArchitecture.repository;

import com.example.HexagonalArchitecture.Infrastructure.H2UserRepository;
import com.example.HexagonalArchitecture.Infrastructure.PostgresUserRepository;
import com.example.HexagonalArchitecture.domain.H2DBRepository;
import com.example.HexagonalArchitecture.domain.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Profile("postgres")
    @Qualifier("postgres")
    public UserRepository userRepositoryPostgresql(PostgresUserRepository postgresUserRepository) {
        return postgresUserRepository;
    }

    // DB 신규 추가시
    @Bean
    @Profile("h2")
    @Qualifier("h2Repository")
    public H2DBRepository testRepositoryH2(H2UserRepository h2UserRepository) {
        return h2UserRepository;
    }
}
