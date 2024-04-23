package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.application.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Adapter layer
 */

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 사용자 관련 기능을 구현 예정이다.
     * @return 사용자 리스트
     */

}
