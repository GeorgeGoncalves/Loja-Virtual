package com.example.loja.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Produto representa os itens da loja virtual.
 * Cada produto possui atributos básicos como nome, descrição,
 * preço e quantidade em estoque.
 */
@Entity
public class Produto {

	// Identificador único do produto (chave primária)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Nome do produto (ex: "Notebook Dell")
    private String nome;
    
    // Descrição detalhada do produto
    private String descricao;
    
    // Preço unitário do produto
    private Double preco;
    
    // Quantidade disponível em estoque
    private Integer quantidadeEstoque;
    
    // Constructor vazio (obrigatório para JPA)
	public Produto() {
	}

	// Construtor completo para facilitar criação de objetos
	public Produto(String nome, String descricao, Double preco, Integer quantidadeEstoque) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	// Getters e Setters para acessar e modificar os atributos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}
