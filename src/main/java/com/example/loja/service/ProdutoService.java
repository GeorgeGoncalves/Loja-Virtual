package com.example.loja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.loja.entities.Produto;
import com.example.loja.repository.ProdutoRepository;

/**
 * Camada de serviço responsável pela lógica de negócio de Produto.
 * Centraliza operações de CRUD e futuras validações/regra de estoque.
 */
@Service
public class ProdutoService {

	private final ProdutoRepository repository;

	// Injeção via construtor
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Salvar ou atualizar produto
    public Produto save(Produto produto) {
        return repository.save(produto);
    }
    
    // Buscar todos os produtos
    public List<Produto> findAll() {
        return repository.findAll();
    }

    // Buscar produto por ID
    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(
        		"Produto não encontrado com id: " + id));
    }

    // Deleta produto por ID
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}