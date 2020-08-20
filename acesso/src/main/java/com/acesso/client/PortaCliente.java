package com.acesso.client;

import com.acesso.configuration.ClienteClientConfiguration;
import com.acesso.configuration.PortaClientConfiguration;
import com.acesso.dto.PortaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "porta", configuration = PortaClientConfiguration.class)
public interface PortaCliente {

    @GetMapping("/porta/{id}")
    public PortaDTO buscaPorId(@PathVariable("id") Long id);

    }
