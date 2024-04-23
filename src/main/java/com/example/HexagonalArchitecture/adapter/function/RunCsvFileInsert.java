package com.example.HexagonalArchitecture.adapter.function;

import com.example.HexagonalArchitecture.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class RunCsvFileInsert {

    // postgresql connection
    public static Connection connectionSQL() throws SQLException {
        return DatabaseConnection.connect();
    }

    // postgresql connection with specific file
    public static void connectionSQLForInsertFileWithSpecificFile() throws SQLException {
        Connection conn = DatabaseConnection.connect();
        CSVTableCreator.createTableFromCSV(conn, "C:\\Users\\김승현\\Desktop\\open data set\\heart_attack_prediction_dataset.csv");
    }

    // H2 DB connection
    public static Connection H2connectionSQL() throws SQLException {
        return DatabaseConnection.connectH2();
    }

    // H2 DB connection with specific file
    public static void H2connectionSQLForInsertFileWithSpecificFile() throws SQLException {
        Connection conn = DatabaseConnection.connectH2();
        CSVTableCreator.createTableFromCSV(conn, "C:\\Users\\김승현\\Desktop\\open data set\\heart_attack_prediction_dataset.csv");
    }

}
