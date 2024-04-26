package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.domain.TestingRepository;
import org.springframework.stereotype.Service;

/**
 * Application layer (port)
 */
@Service
public class TestingServiceImpl implements TestingService {

    private final TestingRepository testingRepository;

    public TestingServiceImpl(TestingRepository testingRepository) {
        this.testingRepository = testingRepository;
    }

}
