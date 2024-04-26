package com.example.HexagonalArchitecture.Infrastructure;

import com.example.HexagonalArchitecture.domain.TestingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("h2")
@Repository
public class TestingRepositoryImpl implements TestingRepository {


}
