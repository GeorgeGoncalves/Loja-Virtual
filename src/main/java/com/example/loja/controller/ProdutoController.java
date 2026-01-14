package com.example.loja.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja.dto.ProdutoDTO;
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
	private ModelMapper modelMapper;

	// Injeção via construtor
    public ProdutoController(ProdutoService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

 // Lista todos os produtos
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        List<Produto> produtos = service.findAll();
        List<ProdutoDTO> dtos = produtos.stream().map(produto -> modelMapper.map(
        		produto, ProdutoDTO.class))
                .toList();
        return ResponseEntity.ok(dtos);
    }
    
    // Criar novo produto
    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        Produto saved = service.save(produto);
        ProdutoDTO dto = modelMapper.map(saved, ProdutoDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable Long id) {
        Produto produto = service.findById(id);
        ProdutoDTO dto = modelMapper.map(produto, ProdutoDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Deletar produto por ID
    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        service.deleteById(id);
    }
}