package com.example.demo.services.XmlProvider;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class XmlService {

    private String path = "/c/Users/deinf.abrao/projects/spi/Interface de Comunicação/mensagens/exemplos/pacs008/assinado/pacs008-001-08_CONTA_100_msg_assinado.xml";
    public String xml;

    public XmlService() {
        try {
            this.xml = Files.readAllLines(Paths.get(path)).stream().reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
