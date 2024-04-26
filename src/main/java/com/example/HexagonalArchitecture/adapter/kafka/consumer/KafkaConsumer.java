package com.example.HexagonalArchitecture.adapter.kafka.consumer;

import com.example.HexagonalArchitecture.dto.MessageDTO;
import com.example.HexagonalArchitecture.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class KafkaConsumer {

    @Autowired
    private MessageMapper messageMapper;

    @KafkaListener(topics = "exam", groupId = "zzanggu-test")
    public void consume(String message, String key) {
        try {
            // get today's date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            String today = formatter.format(date);

            // Save the message and its key to a local file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("kafka_messages.txt", true))) {
                writer.write(today + " : " + message + "\n");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
                e.printStackTrace();
            }

            // Insert the message into the database
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setTimestamp(today);
            messageDTO.setMessage(message);
            messageMapper.insertMessage(messageDTO);

            System.out.printf("Consumed message : %s%n", message);
        } catch (Exception e) {
            System.err.println("Error in consume method: " + e.getMessage());
            e.printStackTrace();
        }
    }
}