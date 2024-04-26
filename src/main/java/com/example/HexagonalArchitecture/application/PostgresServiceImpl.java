package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.domain.PostgresRepository;
import com.example.HexagonalArchitecture.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application layer (port)
 */

@Service
public class PostgresServiceImpl implements PostgresService {
    private final PostgresRepository postgresRepository;

    @Autowired
    public PostgresServiceImpl(PostgresRepository postgresRepository) {
        this.postgresRepository = postgresRepository;
    }

    @Override
    public List<UserDTO> getUserList() {
        return postgresRepository.getUserList();
    }
}
