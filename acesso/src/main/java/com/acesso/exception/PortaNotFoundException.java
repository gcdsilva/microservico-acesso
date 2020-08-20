package com.acesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Porta não encontrado")
public class PortaNotFoundException extends Exception {
}
