package com.example.demo.services.publishSubscribe;

import com.example.demo.services.XmlProvider.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Service
public class Enviar {

    @Autowired
    private KafkaTemplate<Integer, String> template;

    @Autowired
    private XmlService xmlService;

    @Scheduled(fixedDelay = 250L)
    public void run () throws ExecutionException, InterruptedException {
        template.setDefaultTopic("test");
//        System.out.println(template.partitionsFor("test"));

        ListenableFuture<SendResult<Integer, String>> future = template.send("test", xmlService.xml);
//        System.out.println(future.get());
    }
}
