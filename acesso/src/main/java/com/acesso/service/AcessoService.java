package com.acesso.service;

import com.acesso.client.ClienteClient;
import com.acesso.client.PortaCliente;
import com.acesso.dto.ClienteDTO;
import com.acesso.dto.PortaDTO;
import com.acesso.entity.Acesso;
import com.acesso.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AcessoService {

    @Autowired
    AcessoRepository repository;

    @Autowired
    ClienteClient clienteClient;

    @Autowired
    PortaCliente portaClient;

    public Acesso criar(Acesso acesso) {

        ClienteDTO cliente = clienteClient.buscarPorId(acesso.getClienteId());
        PortaDTO porta = portaClient.buscaPorId(acesso.getPortaId());


        if(cliente.getClienteId() == null && cliente.getClienteId() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não encontrado nenhum cliente");
        }

        return repository.save(new Acesso(porta.getId(), Long.parseLong(cliente.getClienteId())));
    }

    public void excluir(String clienteId, String portaId) {
        repository.deleteById(Long.parseLong(portaId));
    }

    public Acesso buscar(String clienteId, String portaId) {

        Acesso acesso = repository.buscar(Long.parseLong(clienteId), Long.parseLong(portaId));

        return acesso;
    }
}
