package com.example.loja.repository;

import com.example.loja.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA para Pedido.
 * Herda operações CRUD prontas do Spring Data JPA.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}