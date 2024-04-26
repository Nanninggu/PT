package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.adapter.function.GetData;
import com.example.HexagonalArchitecture.adapter.function.RunPython;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Adapter layer
 */
@RestController
@RequestMapping("/api/v1")
public class TestingController {

    /**
     * Test 메소드 이다.
     *
     * @return 값은 test 이다.
     */
    @GetMapping("/test")
    public String readMovieList() {
        System.out.println("Return test value.");
        String returnValue = "Return test value.";
        return returnValue;
    }

    /**
     * DB에 저장되어 있는 데이터를
     * 정상적으로 읽어오는지 테스트 하는 컨트롤러
     *
     * @throws SQLException
     */
    @GetMapping("/read-data-from-db")
    public void readMovieList2() throws SQLException {
        System.out.println("New method2");
        // DB에 저장되어 있는 데이터를 정상적으로 읽어오는지 확인
        GetData.getDataFromAaa();
    }

    /**
     * check python script
     *
     * @throws SQLException
     */
    @GetMapping("/check-run-python-script")
    public void checkPythonScript() throws SQLException {
        System.out.println("New method3");
        // check python script
        RunPython.runOutputForRunScript();
    }

}
