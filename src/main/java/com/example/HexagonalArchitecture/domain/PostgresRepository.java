package com.example.HexagonalArchitecture.domain;

import com.example.HexagonalArchitecture.dto.UserDTO;

import java.util.List;

/**
 * Domain layer
 * DB가 변경되어도 Domain Layer 는 바뀌는게 없다.
 */

public interface PostgresRepository {

    List<UserDTO> getUserList();
}
