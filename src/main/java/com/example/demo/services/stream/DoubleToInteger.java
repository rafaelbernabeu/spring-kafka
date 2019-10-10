package com.example.demo.services.stream;

import org.springframework.stereotype.Component;

@Component
public class DoubleToInteger {

//    @Bean
//    public KStream<String, String> doubleToIntegerM(StreamsBuilder kStreamBuilder) {
//        KStream<String, String> stream = kStreamBuilder.stream("test");
//
//        stream.peek((k, v) -> System.out.println("Value: " + v))
//                .mapValues((k, v) -> {
//                    try {
//                        return String.valueOf(Double.valueOf(v).intValue());
//                    } catch (Exception e) {
//                        return null;
//                    }
//                })
//                .to("test2");
//
////        stream.print(Printed.toSysOut());
//
//        return stream;
//    }
}
