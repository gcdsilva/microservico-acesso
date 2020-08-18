package com.acesso.client;

import com.acesso.configuration.ClienteClientConfiguration;
import com.acesso.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cliente", configuration = ClienteClientConfiguration.class)
public interface ClienteClient {

    @GetMapping("/cliente/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id);
}