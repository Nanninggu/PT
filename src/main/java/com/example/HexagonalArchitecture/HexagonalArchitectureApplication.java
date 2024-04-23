package com.example.HexagonalArchitecture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.HexagonalArchitecture", "com.example.HexagonalArchitecture.Infrastructure"})
@MapperScan("com.example.HexagonalArchitecture.mapper")
public class HexagonalArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureApplication.class, args);
    }

}
