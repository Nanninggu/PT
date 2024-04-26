package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.dto.UserDTO;

import java.util.List;

/**
 * Application layer
 */

public interface PostgresService {

    List<UserDTO> getUserList();
}
