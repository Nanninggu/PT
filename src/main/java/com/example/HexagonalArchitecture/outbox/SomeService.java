package com.example.HexagonalArchitecture.outbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SomeService {
    private final DomainEventMapper domainEventMapper;

    @Autowired
    public SomeService(DomainEventMapper domainEventMapper) {
        this.domainEventMapper = domainEventMapper;
    }

    @Transactional
    public void performSomeOperation() {

        domainEventMapper.findAll();
    }

    @Transactional
    public void performSomeOperationInsert(DomainEvent event) {
        // populate the event...
        domainEventMapper.insert(event);
    }
}
