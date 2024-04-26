package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.dto.TestDTO;

import java.util.List;

/**
 * Application layer
 */
public interface H2Service {

    List<TestDTO> getDBUserOfH2();

    List<TestDTO> getDBUserOfH2Mybatis();

    void insertAutoRefreshTest(String username, String email);

}
