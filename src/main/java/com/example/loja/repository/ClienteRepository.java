package com.example.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loja.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}