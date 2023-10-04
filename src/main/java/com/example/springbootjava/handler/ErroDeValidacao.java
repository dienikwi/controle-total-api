package com.example.springbootjava.handler;

public class ErroDeValidacao {
    private final String mensagem;

    public ErroDeValidacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}