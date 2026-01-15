package com.example.loja.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.loja.entities.StatusPedido;

public class PedidoDTO {
	private Long Id;
	private Long clienteId;
	private List<Long> produtosIds;
	private LocalDateTime dataPedido;
	private Double valorTotal;
	private StatusPedido status;

	// Construtor vazio
	public PedidoDTO() {
	}

	// Construtor
	public PedidoDTO(Long Id, Long clienteId, List<Long> produtosIds, LocalDateTime dataPedido, Double valorTotal,
			StatusPedido status) {
		this.Id = Id;
		this.clienteId = clienteId;
		this.produtosIds = produtosIds;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.status = status;

	}

	// Getters e Setters
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<Long> getProdutosIds() {
		return produtosIds;
	}

	public void setProdutosIds(List<Long> produtosIds) {
		this.produtosIds = produtosIds;
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
}