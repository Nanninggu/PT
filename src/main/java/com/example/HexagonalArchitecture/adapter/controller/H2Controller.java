package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.application.H2Service;
import com.example.HexagonalArchitecture.dto.TestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Adapter layer
 */

@RestController
@RequestMapping("/api/v1")
public class H2Controller {

    private final H2Service h2Service;

    public H2Controller(H2Service h2Service) {
        this.h2Service = h2Service;
    }

    /**
     * H2 DB의 사용자 리스트를 조회
     *
     * @return
     */
    @GetMapping("/h2-user-table")
    public ModelAndView h2_user_table() {
        List<TestDTO> result = h2Service.getDBUserOfH2();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", result);
        return modelAndView;
    }

    @GetMapping("/h2-user-table-mybatis")
    public ModelAndView h2_user_table_mybatis() {
        List<TestDTO> result = h2Service.getDBUserOfH2Mybatis();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("users", result);
        return modelAndView;
    }

    @PostMapping("h2-insert-auto-refresh-test")
    public void h2_insert_auto_refresh_test(String username, String email) {
        h2Service.insertAutoRefreshTest(username, email);
    }

}
