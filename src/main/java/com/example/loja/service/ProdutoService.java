package com.example.loja.service;

import java.util.List;
import java.util.Optional;

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

    // Cria ou atualiza um produto
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    // Lista todos os produtos
    public List<Produto> listar() {
        return repository.findAll();
    }

    // Busca um produto por ID
    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Deleta um produto por ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}