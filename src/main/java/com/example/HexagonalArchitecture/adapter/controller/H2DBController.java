package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.application.H2DBService;
import com.example.HexagonalArchitecture.dto.TestInfo;
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
public class H2DBController {

    private final H2DBService h2DBService;

    public H2DBController(H2DBService h2DBService) {
        this.h2DBService = h2DBService;
    }

    /**
     * H2 DB의 사용자 리스트를 조회
     * @return
     */
    @GetMapping("/h2-user-table")
    public ModelAndView h2_user_table() {
        List<TestInfo> result = h2DBService.getDBUserOfH2();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", result);
        return modelAndView;
    }

    @GetMapping("/h2-user-table-mybatis")
    public ModelAndView h2_user_table_mybatis() {
        List<TestInfo> result = h2DBService.getDBUserOfH2Mybatis();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("users", result);
        return modelAndView;
    }

    @PostMapping("h2-insert-auto-refresh-test")
    public void h2_insert_auto_refresh_test(String username, String email) {
        h2DBService.insertAutoRefreshTest(username, email);
    }

}
