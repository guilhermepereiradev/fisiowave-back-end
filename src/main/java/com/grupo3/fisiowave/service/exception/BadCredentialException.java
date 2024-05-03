package com.grupo3.fisiowave.service.exception;

public class BadCredentialException extends RuntimeException {
    public BadCredentialException(String mensagem) {
        super(mensagem);
    }
}
