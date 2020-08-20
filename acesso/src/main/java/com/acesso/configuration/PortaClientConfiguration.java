package com.acesso.configuration;

import com.acesso.decoder.ClienteClientDecoder;
import com.acesso.decoder.PortaClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PortaClientConfiguration {

    @Bean
    public ErrorDecoder buscaPorId() {
        return new PortaClientDecoder();
    }
}
