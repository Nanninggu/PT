package com.example.HexagonalArchitecture.adapter.function;

import com.example.HexagonalArchitecture.connection.DBConnectionConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class FileInsert {

    // postgresql connection
    public static Connection connectionSQL() throws SQLException {
        return DBConnectionConfig.connect();
    }

    // postgresql connection with specific file
    public static void connectionSQLForInsertFileWithSpecificFile() throws SQLException {
        Connection conn = DBConnectionConfig.connect();
        TableCreator.createTableFromCSV(conn, "C:\\Users\\김승현\\Desktop\\open data set\\heart_attack_prediction_dataset.csv");
    }

    // H2 DB connection
    public static Connection H2connectionSQL() throws SQLException {
        return DBConnectionConfig.connectH2();
    }

    // H2 DB connection with specific file
    public static void H2connectionSQLForInsertFileWithSpecificFile() throws SQLException {
        Connection conn = DBConnectionConfig.connectH2();
        TableCreator.createTableFromCSV(conn, "C:\\Users\\김승현\\Desktop\\open data set\\heart_attack_prediction_dataset.csv");
    }

}
