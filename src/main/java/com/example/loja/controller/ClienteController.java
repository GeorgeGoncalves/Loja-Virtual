package com.example.loja.controller;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.loja.dto.ClienteDTO;
import com.example.loja.entities.Cliente;
import com.example.loja.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;
    private final ModelMapper modelMapper;

    // Injeção com construtor
    public ClienteController(ClienteService clienteService, ModelMapper modelMapper) {
        this.service = clienteService;
        this.modelMapper = modelMapper;
    }

    // Lista todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<Cliente> clientes = service.findAll();
        List<ClienteDTO> dtos = clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {
        Cliente cliente = service.findById(id);
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Criar cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente saved = service.save(cliente);
        ClienteDTO dto = modelMapper.map(saved, ClienteDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Deletar por id
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deleteById(id);
    }
}