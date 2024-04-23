package com.example.HexagonalArchitecture.domain;

import com.example.HexagonalArchitecture.dto.TestInfo;

import java.util.List;

/**
 * Domain layer
 * DB가 변경되어도 Domain Layer 는 바뀌는게 없다.
 */
public interface H2DBRepository {

    List<TestInfo> getDBUserOfH2();

    List<TestInfo> getDBUserOfMybatis();

    void insertAutoRefreshTest(String username, String email);
}
