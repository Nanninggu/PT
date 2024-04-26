package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.domain.H2Repository;
import com.example.HexagonalArchitecture.dto.TestDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application layer (port)
 */
@Service
public class H2ServiceImpl implements H2Service {

    private final H2Repository h2Repository;

    public H2ServiceImpl(@Qualifier("h2Repository") H2Repository testRepository) {
        this.h2Repository = testRepository;
    }

    @Override
    public List<TestDTO> getDBUserOfH2() {
        return h2Repository.getDBUserOfH2();
    }

    @Override
    public List<TestDTO> getDBUserOfH2Mybatis() {
        return h2Repository.getDBUserOfMybatis();
    }

    @Override
    public void insertAutoRefreshTest(String username, String email) {
        h2Repository.insertAutoRefreshTest(username, email);
    }

}
