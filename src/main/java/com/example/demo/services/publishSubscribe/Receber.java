package com.example.demo.services.publishSubscribe;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Receber {

    @KafkaListener(id = "foo", topics = "test", groupId = "2")
    public void listen(String data) {
        System.out.println("Consumer1: " + data);
    }

    @KafkaListener(id = "foo2", topics = "test", groupId = "2")
    public void listen2(String data) {
        System.out.println("Consumer2: " + data);
    }

    @KafkaListener(id = "foo3", topics = "test", groupId = "2")
    public void listen3(String data) {
        System.out.println("Consumer3: " + data);
    }
}
