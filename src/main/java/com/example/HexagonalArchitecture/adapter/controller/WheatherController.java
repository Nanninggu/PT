package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.adapter.function.wheather.WheatherToEmail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WheatherController {

    @GetMapping("/getWheather")
    public String getWheather() {
        WheatherToEmail wheatherToEmail = new WheatherToEmail();
        wheatherToEmail.WheatherToEmailMethod();
        return "useReturnValue";
    }

}
