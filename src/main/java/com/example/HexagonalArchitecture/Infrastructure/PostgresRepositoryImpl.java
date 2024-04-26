package com.example.HexagonalArchitecture.Infrastructure;

import com.example.HexagonalArchitecture.domain.PostgresRepository;
import com.example.HexagonalArchitecture.dto.UserDTO;
import com.example.HexagonalArchitecture.mapper.PostgresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("postgres")
@Primary
@Repository
public class PostgresRepositoryImpl implements PostgresRepository {

    @Autowired
    PostgresMapper postgresMapper;

    @Override
    public List<UserDTO> getUserList() {
        return postgresMapper.getUserList();
    }
}
