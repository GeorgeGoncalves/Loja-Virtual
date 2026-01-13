package com.example.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loja.entities.Produto;

/**
 * Repository JPA para Produto.
 * Herda operações CRUD prontas do Spring Data JPA.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
}