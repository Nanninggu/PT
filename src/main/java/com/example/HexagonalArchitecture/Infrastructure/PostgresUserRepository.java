package com.example.HexagonalArchitecture.Infrastructure;

import com.example.HexagonalArchitecture.domain.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("postgres")
@Primary
@Repository
public class PostgresUserRepository implements UserRepository {



}
