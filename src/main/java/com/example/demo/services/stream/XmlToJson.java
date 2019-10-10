package com.example.demo.services.stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class XmlToJson {

    @Bean
    public KStream<String, String> xmlToJsonM(StreamsBuilder kStreamBuilder) {
        KStream<String, String> stream = kStreamBuilder.stream("test");
        stream.mapValues((k, v) -> {

            try {
                XmlMapper xmlMapper = new XmlMapper();
                JsonNode node = xmlMapper.readTree(v.getBytes());
                ObjectMapper jsonMapper = new ObjectMapper();
                return jsonMapper.writeValueAsString(node);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }).to("test2");

        return null;
    }
}
