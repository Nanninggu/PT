package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.dto.TestInfo;
import java.util.List;

/**
 * Application layer
 */
public interface H2DBService {

    List<TestInfo> getDBUserOfH2();

    List<TestInfo> getDBUserOfH2Mybatis();

    void insertAutoRefreshTest(String username, String email);

}
