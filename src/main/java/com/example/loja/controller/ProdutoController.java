package com.example.loja.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja.entities.Produto;
import com.example.loja.service.ProdutoService;

/**
 * Controller REST para Produto.
 * Expõe endpoints para criar, listar, buscar e deletar produtos.
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // Cria um novo produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    // Lista todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    // Busca produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound()
        		.build());
    }

    // Deleta produto por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}