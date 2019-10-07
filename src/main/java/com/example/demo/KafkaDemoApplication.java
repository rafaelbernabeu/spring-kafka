package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@EnableScheduling
@SpringBootApplication
public class KafkaDemoApplication {

    @Autowired
    private KafkaTemplate<Integer, String> template;

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(KafkaDemoApplication.class, args);
        Thread.sleep(5000l);

    }

    @Scheduled(fixedDelay = 500L)
    public void run () throws ExecutionException, InterruptedException {
        template.setDefaultTopic("test");
//        System.out.println(template.partitionsFor("test"));

        ListenableFuture<SendResult<Integer, String>> future = template.send("test", String.valueOf(Math.random()));
//        System.out.println(future.get());
    }

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
