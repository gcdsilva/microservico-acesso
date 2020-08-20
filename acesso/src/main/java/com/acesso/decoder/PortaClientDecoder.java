package com.acesso.decoder;

import com.acesso.exception.ClienteNotFoundException;
import com.acesso.exception.PortaNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PortaClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            return new PortaNotFoundException();
        }
        return errorDecoder.decode(s, response);

    }
}
