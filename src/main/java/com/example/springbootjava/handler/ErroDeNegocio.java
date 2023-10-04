package com.example.springbootjava.handler;

public class ErroDeNegocio extends RuntimeException {
    public ErroDeNegocio(String mensagem) {
        super(mensagem);
    }
}

