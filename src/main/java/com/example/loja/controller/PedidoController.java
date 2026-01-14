package com.example.loja.controller;

import com.example.loja.entities.Pedido;
import com.example.loja.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para Pedido.
 * Expõe endpoints para criar, listar, buscar e deletar pedidos.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService service;

	// Injeção via construtor
    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // Cria um novo pedido
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return service.salvar(pedido);
    }

    // Lista todos os pedidos
    @GetMapping
    public List<Pedido> listar() {
        return service.listar();
    }

    // Busca pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound()
        		.build());
    }

    // Deleta pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}