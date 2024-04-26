package com.example.HexagonalArchitecture.mapper;

import com.example.HexagonalArchitecture.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostgresMapper {

    List<UserDTO> getUserList();
}
