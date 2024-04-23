package com.example.HexagonalArchitecture.application;

import com.example.HexagonalArchitecture.domain.H2DBRepository;
import com.example.HexagonalArchitecture.dto.TestInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application layer (port)
 */
@Service
public class H2DBServiceImpl implements H2DBService {

    private final H2DBRepository h2DBRepository;

    public H2DBServiceImpl(@Qualifier("h2Repository") H2DBRepository testRepository) {
        this.h2DBRepository = testRepository;
    }

    @Override
    public List<TestInfo> getDBUserOfH2() {
        return h2DBRepository.getDBUserOfH2();
    }

    @Override
    public List<TestInfo> getDBUserOfH2Mybatis() {
        return h2DBRepository.getDBUserOfMybatis();
    }

    @Override
    public void insertAutoRefreshTest(String username, String email) {
        h2DBRepository.insertAutoRefreshTest(username, email);
    }

}
