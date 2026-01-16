package com.example.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loja.entity.Pedido;

/**
 * Repository JPA para Pedido.
 * Herda operações CRUD prontas do Spring Data JPA.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}