package com.example.HexagonalArchitecture.Infrastructure;

import com.example.HexagonalArchitecture.domain.H2DBRepository;
import com.example.HexagonalArchitecture.dto.TestInfo;
import com.example.HexagonalArchitecture.mapper.TestMapper;
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
public class H2UserRepository implements H2DBRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    TestMapper testMapper;

    @Override
    public List<TestInfo> getDBUserOfH2() {
        String sql = "SELECT username, email FROM users";

        return jdbcTemplate.query(sql, new RowMapper<TestInfo>() {
            @Override
            public TestInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                TestInfo user = new TestInfo();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }

    @Override
    public List<TestInfo> getDBUserOfMybatis() {
        return testMapper.getDBUserOfH2Mybatis();
    }

    @Override
    public void insertAutoRefreshTest(String username, String email) {
        testMapper.insertAutoRefreshTest(username, email);
    }

}
