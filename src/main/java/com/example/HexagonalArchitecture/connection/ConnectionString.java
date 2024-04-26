package com.example.HexagonalArchitecture.connection;

public class ConnectionString {

    // postgresql connection string
    public static String getConnectionString() {
        return "jdbc:postgresql://localhost:5432/PracticeDB";
    }

    // h2 connection string
    public static String getH2ConnectionString() {
        return "jdbc:h2:./data/demo";
    }
}
