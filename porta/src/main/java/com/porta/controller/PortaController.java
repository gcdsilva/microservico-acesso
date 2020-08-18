package com.porta.controller;

import com.porta.entity.Porta;
import com.porta.service.PortaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/porta")
public class PortaController {

    @Autowired
    PortaService service;

    @PostMapping
    public ResponseEntity<Porta> criar(@RequestBody Porta porta) {

        return new ResponseEntity<Porta>(service.criar(porta), new HttpHeaders(), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Porta> buscaPorId(@PathVariable("id") Long id) {

        return new ResponseEntity<Porta>(service.buscarPorId(id), new HttpHeaders(), HttpStatus.OK);

    }
}
