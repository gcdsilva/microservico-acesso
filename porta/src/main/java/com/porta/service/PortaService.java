package com.porta.service;

import com.porta.entity.Porta;
import com.porta.repository.PortaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortaService {

    @Autowired
    PortaRepository repository;


    public Porta criar(Porta porta) {
        return repository.save(porta);
    }

    public Porta buscarPorId(Long id) {

        Optional<Porta> byId = repository.findById(id);

        return byId.get();
    }
}
