package com.example.HexagonalArchitecture.Infrastructure;

import com.example.HexagonalArchitecture.domain.H2Repository;
import com.example.HexagonalArchitecture.dto.TestDTO;
import com.example.HexagonalArchitecture.mapper.TestingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Profile("h2")
@Repository
public class H2RepositoryImpl implements H2Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    TestingMapper testingMapper;

    @Override
    public List<TestDTO> getDBUserOfH2() {
        String sql = "SELECT username, email FROM users";

        return jdbcTemplate.query(sql, new RowMapper<TestDTO>() {
            @Override
            public TestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                TestDTO user = new TestDTO();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }

    @Override
    public List<TestDTO> getDBUserOfMybatis() {
        return testingMapper.getDBUserOfH2Mybatis();
    }

    @Override
    public void insertAutoRefreshTest(String username, String email) {
        testingMapper.insertAutoRefreshTest(username, email);
    }

}
