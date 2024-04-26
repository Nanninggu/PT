package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.adapter.function.FileInsert;
import com.example.HexagonalArchitecture.adapter.function.RunPython;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class DataHandlingController {

    /**
     * Python 스크립트를 실행하여
     * Kaggle에 있는 특정 DataSet
     * 파일을 다운로드 받는다.
     *
     * @return
     */
    @GetMapping("/download-file")
    public String downloadFile() {
        System.out.println("Download file in kaggle");
        RunPython runPython = new RunPython();
        try {
            RunPython.downloadFilesInKaggle();
            System.out.println("Downloaded file successfully of file existing in kaggle.");
        } catch (Exception e) {
            System.out.println("Error running Python script: " + e.getMessage());
            e.printStackTrace();
        }
        return "Kaggle file downloaded successfully.";
    }

    /**
     * CSV 파일을 읽어서 자동으로
     * 테이블과 컬럼을 생성한다.
     *
     * @return
     */
    @GetMapping("/create-table-csv")
    public String createTableAndColumFromHeader() throws SQLException {
        FileInsert.connectionSQL();
        FileInsert.connectionSQLForInsertFileWithSpecificFile();
        return "Table Colum Created Successfully.";
    }

    /**
     * CSV 파일을 읽어서 자동으로
     * H2 DB 테이블과 컬럼을 생성한다.
     *
     * @return
     */
    @GetMapping("/h2-create-table-csv")
    public String H2createTableAndColumFromHeader() throws SQLException {
        FileInsert.H2connectionSQL();
        FileInsert.H2connectionSQLForInsertFileWithSpecificFile();
        return "DB of H2 Table Colum Created Successfully.";
    }

    /**
     * CSV 파일을 읽어서 자동으로
     * 데이터를 테이블에 삽입한다.
     *
     * @return
     */
    @GetMapping("/insert-csv-data")
    public String insertDataToTable() throws SQLException {

        System.out.println("inserting file of kaggle");
        RunPython runPython = new RunPython();
        try {
            RunPython.insertFileOfCSV();
            System.out.println("Inserted file successfully of file existing of kaggle.");
        } catch (Exception e) {
            System.out.println("Error running Python script: " + e.getMessage());
            e.printStackTrace();
        }
        return "CSV data inserted successfully.";
    }

}