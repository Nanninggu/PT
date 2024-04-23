package com.example.HexagonalArchitecture.adapter.function;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunPythonScript {
    public static void downloadFilesInKaggle() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "src/python/kaggle/main.py");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (Exception e) {
            System.out.println("Error running Python script: " + e.getMessage());
        }
    }

    // python code runner
    public static void insertFileOfCSV() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "src/python/kaggle/db_insert.py");
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (Exception e) {
            System.out.println("Error running Python script: " + e.getMessage());
        }
    }

    // python code runner
    public static void runOutputForRunScript() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "src/python/kaggle/output.py");

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (Exception e) {
            System.out.println("Error running Python script: " + e.getMessage());
        }
    }

}
