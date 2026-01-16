package com.example.loja.controller;

import com.example.loja.dto.PedidoDTO;
import com.example.loja.entity.Pedido;
import com.example.loja.service.PedidoService;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller REST para Pedido. Expõe endpoints para criar, listar, buscar e
 * deletar pedidos.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService service;
	private final ModelMapper modelMapper;

	// Injeção via construtor
	public PedidoController(PedidoService service, ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}

	// Criar novo pedido
	@PostMapping
	public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
		Pedido saved = service.saveFromDTO(pedidoDTO);
		PedidoDTO dto = service.toDTO(saved);
		return ResponseEntity.ok(dto);
	}

	// Listar todos os pedidos
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
		List<Pedido> pedidos = service.findAll();
		List<PedidoDTO> dtos = pedidos.stream().map(p -> service.toDTO(p)).collect(Collectors.
				toList());

		return ResponseEntity.ok(dtos);
	}

	// Busca pedido por ID
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> getPedido(@PathVariable Long id) {
		Pedido pedido = service.findById(id);
		PedidoDTO dto = modelMapper.map(pedido, PedidoDTO.class);
		return ResponseEntity.ok(dto);
	}

	// Deletar pedido por ID
	@DeleteMapping("/{id}")
	public void deletePedido(@PathVariable Long id) {
		service.deleteById(id);
	}
}