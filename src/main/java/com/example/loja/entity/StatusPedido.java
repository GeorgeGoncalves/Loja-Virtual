package com.example.loja.entity;

/**
 * Enum StatusPedido representa os estados possíveis de um pedido.
 * Usamos Enum porque os valores são fixos e limitados.
 */
public enum StatusPedido {
	PENDENTE,   // Pedido criado, aguardando pagamento
    PAGO,       // Pedido já pago
    ENVIADO,    // Pedido enviado para o cliente
    ENTREGUE,   // Pedido entregue ao cliente
    CANCELADO   // Pedido cancelado
}