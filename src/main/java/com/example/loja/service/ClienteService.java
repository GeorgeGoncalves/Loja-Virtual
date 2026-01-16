package com.example.loja.service;

import org.springframework.stereotype.Service;

import com.example.loja.entity.Cliente;
import com.example.loja.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Salvar cliente
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Buscar todos
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Buscar por id
    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    // Deletar por id
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}