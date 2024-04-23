package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.domain.NewRepository;
import org.springframework.stereotype.Service;

/**
 * Application layer (port)
 */
@Service
public class NewServiceImpl implements NewService{

    private final NewRepository newRepository;

    public NewServiceImpl(NewRepository newRepository) {
        this.newRepository = newRepository;
    }

}
