package com.example.HexagonalArchitecture.mapper;
import com.example.HexagonalArchitecture.dto.TestInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {

    List<TestInfo> getDBUserOfH2Mybatis();

    void insertAutoRefreshTest(String username, String email);
}
