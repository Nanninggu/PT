package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.application.PostgresService;
import com.example.HexagonalArchitecture.connection.DBConnectionConfig;
import com.example.HexagonalArchitecture.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Adapter layer
 */

@RestController
@RequestMapping("/api/v1")
public class PostgresController {
    private final PostgresService postgresService;

    // Postgres Connection
    private final Connection connection = DBConnectionConfig.connect();

    public PostgresController(PostgresService postgresService) throws SQLException {
        this.postgresService = postgresService;
    }

    @GetMapping("/data-of-kaggle")
    public List<UserDTO> getUserList() throws SQLException {
        return postgresService.getUserList();
    }

}
