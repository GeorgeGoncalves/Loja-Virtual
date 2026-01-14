package com.example.loja.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {
	private Long id;
    private ClienteDTO cliente;
    private List<ProdutoDTO> produtos;
    private LocalDateTime dataPedido;
    private Double valorTotal;
    private String status;

    // Construtor vazio
    public PedidoDTO() {
	}

    // Construtor
	public PedidoDTO(Long id, ClienteDTO cliente, List<ProdutoDTO> produtos,
                     LocalDateTime dataPedido, Double valorTotal, String status) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    // Getters e Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}