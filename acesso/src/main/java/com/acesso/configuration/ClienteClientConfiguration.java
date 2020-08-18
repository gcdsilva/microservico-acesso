package com.acesso.configuration;

import com.acesso.decoder.ClienteClientDecoder;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class ClienteClientConfiguration {

    @Bean
    public ErrorDecoder buscarPorIdDecoder() {
        return new ClienteClientDecoder();
    }

}
