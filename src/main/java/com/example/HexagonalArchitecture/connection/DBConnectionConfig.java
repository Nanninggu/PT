package com.example.HexagonalArchitecture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnectionConfig {

    public static Connection connect() throws SQLException {
        String url = ConnectionString.getConnectionString();
        String username = "postgres";
        String password = "test1234";

        if (username == null || password == null) {
            throw new SQLException("Database credentials not set in environment variables.");
        }

        return DriverManager.getConnection(url, username, password);
    }

    public static Connection connectH2() throws SQLException {
        String url = ConnectionString.getH2ConnectionString();
        String username = "sa";
        String password = "test1234";

        if (username == null || password == null) {
            throw new SQLException("H2 Database credentials not set in environment variables.");
        }

        return DriverManager.getConnection(url, username, password);
    }

}
