package com.consumer;


import com.acesso.AcessoLog;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class AcessoConsumer {


    @KafkaListener(topics = "spec4-guilherme-cabral-1", groupId = "GuilhermeCabral")
    public void receber(@Payload AcessoLog acesso) throws IOException {
        System.out.println("Recebi o cliente " + acesso.getClienteId() + " acesso a porta " + acesso.getPortaId() + " é autorizado " + acesso.isAutorizado());

        criarCsv(acesso);
    }

    private void criarCsv(AcessoLog acesso) throws IOException {

        String[] cabecalho = {"cliente", "porta", "autorizado"};
        List<String[]> linhas = new ArrayList<>();
        linhas.add(new String[]{acesso.getClienteId().toString(), acesso.getPortaId().toString(), String.valueOf(acesso.isAutorizado())});

        Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/acesso.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
    }

}
