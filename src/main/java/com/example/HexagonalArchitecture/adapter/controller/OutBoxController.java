package com.example.HexagonalArchitecture.adapter.controller;

import com.example.HexagonalArchitecture.outbox.DomainEvent;
import com.example.HexagonalArchitecture.outbox.SomeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OutBoxController {

    private final SomeService someService;

    public OutBoxController(SomeService someService) {
        this.someService = someService;
    }

    @GetMapping("/outbox")
    public String outbox() {
        someService.performSomeOperation();
        return "Outbox";
    }

    @PostMapping("/outbox")
    public String createEvent(@RequestBody DomainEvent event) {
        someService.performSomeOperationInsert(event);
        return "Event created";
    }

}
