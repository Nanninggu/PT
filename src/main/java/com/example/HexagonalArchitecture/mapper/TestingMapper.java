package com.example.HexagonalArchitecture.mapper;
import com.example.HexagonalArchitecture.dto.TestDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestingMapper {

    List<TestDTO> getDBUserOfH2Mybatis();

    void insertAutoRefreshTest(String username, String email);
}
