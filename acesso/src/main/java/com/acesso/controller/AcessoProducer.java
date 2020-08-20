package com.acesso.controller;

import com.acesso.AcessoLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AcessoProducer {

    @Autowired
    private KafkaTemplate<String, AcessoLog> producer;

    public void enviarAoKafka(AcessoLog acessoLog) {
//        for (int i = 0; i < 40; i++) {
//            producer.send("spec4-biblioteca", i, "1", livro);
//        }


        producer.send("spec4-guilherme-cabral-1", acessoLog);
    }

}
