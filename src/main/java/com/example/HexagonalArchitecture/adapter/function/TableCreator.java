package com.example.HexagonalArchitecture.adapter.function;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TableCreator {

    /**
     * CSV 파일을 읽고 해당 CSV 파일의 헤더를
     * 읽어서 자동으로 테이블을 만들어주는 코드
     *
     * @param conn
     * @param filePath
     */
    public static void createTableFromCSV(Connection conn, String filePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVReader csvReader = new CSVReader(reader)) {

            // Read the first line from the CSV file
            String[] headers = csvReader.readNext();

            // Sanitize the headers
            String[] sanitizedHeaders = Arrays.stream(headers)
                    .map(header -> header.replaceAll("\\W", "_"))
                    .toArray(String[]::new);

            // Construct the CREATE TABLE statement
            String sql = "CREATE TABLE IF NOT EXISTS csv_table (" +
                    Arrays.stream(sanitizedHeaders)
                            .map(header -> header + " VARCHAR(255)")
                            .collect(Collectors.joining(", ")) +
                    ")";

            // Execute the CREATE TABLE statement
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table created successfully.");
            }

        } catch (IOException | CsvException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
