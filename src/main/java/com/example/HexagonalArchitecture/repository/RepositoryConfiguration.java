package com.example.HexagonalArchitecture.repository;

import com.example.HexagonalArchitecture.Infrastructure.H2RepositoryImpl;
import com.example.HexagonalArchitecture.Infrastructure.PostgresRepositoryImpl;
import com.example.HexagonalArchitecture.domain.H2Repository;
import com.example.HexagonalArchitecture.domain.PostgresRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Profile("postgres")
    @Qualifier("postgres")
    public PostgresRepository userRepositoryPostgresql(PostgresRepositoryImpl postgresUserRepository) {
        return postgresUserRepository;
    }

    // DB 신규 추가시
    @Bean
    @Profile("h2")
    @Qualifier("h2Repository")
    public H2Repository testRepositoryH2(H2RepositoryImpl h2RepositoryImpl) {
        return h2RepositoryImpl;
    }

}
