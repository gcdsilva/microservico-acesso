package com.acesso.controller;

import com.acesso.AcessoLog;
import com.acesso.entity.Acesso;
import com.acesso.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    @Autowired
    AcessoService service;

    @Autowired
    AcessoProducer acessoProducer;

    @PostMapping
    public ResponseEntity<Acesso> criar(@RequestBody Acesso acesso){
        return new ResponseEntity<Acesso>(service.criar(acesso), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{cliente_id}/{porta_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("cliente_id") String clienteId, @PathVariable("porta_id") String portaId) {

        service.excluir(clienteId, portaId);

    }

    @GetMapping("/{cliente_id}/{porta_id}")
    public Acesso buscar(@PathVariable("cliente_id") String clienteId, @PathVariable("porta_id") String portaId) {

        Acesso acesso = service.buscar(clienteId, portaId);

        AcessoLog acessoLog = AcessoMapper.from(acesso);

        acessoProducer.enviarAoKafka(acessoLog);

        return acesso;

    }


    }
