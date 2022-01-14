package com.fernandocandiotti.exception;

public class PedidoNaoEncontratoException extends RuntimeException {
    public PedidoNaoEncontratoException() {
        super("Pedido Não Encontrado.");
    }
}
