package com.example.HexagonalArchitecture.adapter.function;

import com.example.HexagonalArchitecture.connection.DBConnectionConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {

    public static void getDataFromAaa() throws SQLException {
        Connection conn = DBConnectionConfig.connect();

        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT id, password FROM public.aaa";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String password = rs.getString("password");

                System.out.println("ID: " + id + ", Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Error getting data from table aaa: " + e.getMessage());
            throw e;
        }
    }

}
