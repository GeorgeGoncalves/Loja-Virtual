package com.example.loja.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidade Pedido representa uma transação realizada por um Cliente.
 * Cada pedido possui um cliente associado, uma lista de produtos,
 * a data da compra e o valor total.
 */
@Entity
public class Pedido {

	// Identificador único da compra (chave primária)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento: uma compra pertence a um cliente
    // Muitos pedidos podem estar ligados a um único cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id") // cria a coluna cliente_id na tabela Compra
    private Cliente cliente;

    // Relacionamento: uma compra pode ter vários produtos
    // Usamos ManyToMany porque vários produtos podem estar em várias compras
    @ManyToMany
    @JoinTable(
    		name = "pedido_produto", // tabela intermediária
        joinColumns = @JoinColumn(name = "pedido_id"), // chave da compra
        inverseJoinColumns = @JoinColumn(name = "produto_id") // chave do produto
    )

    private List<Produto> produtos;

    // Data e hora em que a compra foi realizada
    private LocalDateTime dataPedido;

    // Valor total da compra
    private Double valorTotal;

    // Status do pedido (enum)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    // Construtor vazio (obrigatório para JPA)
    public Pedido() {
    	
    }
	
	// construtor
    public Pedido(Cliente cliente, List<Produto> produtos, LocalDateTime dataPedido,
                  StatusPedido status) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataPedido = dataPedido;
        this.status = status;
        this.valorTotal = calcularValorTotal();
    }

	// Getters e Setters para acessar e modificar os atributos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	// Método que calcula o valor total baseado nos produtos
    public Double calcularValorTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}