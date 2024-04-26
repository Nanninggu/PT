package com.example.HexagonalArchitecture.outbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutboxPublisher {
    private final DomainEventMapper domainEventMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public OutboxPublisher(DomainEventMapper domainEventMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.domainEventMapper = domainEventMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 5000) // run every 5 seconds
    public void publishEvents() {
        List<DomainEvent> events = domainEventMapper.findAll();
        for (DomainEvent event : events) {
            kafkaTemplate.send("topicName", event.getPayload());
            domainEventMapper.delete(event.getId());
        }
    }
}
