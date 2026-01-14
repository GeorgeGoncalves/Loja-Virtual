package com.example.loja.service;

import com.example.loja.entities.Pedido;
import com.example.loja.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável pela lógica de negócio de Pedido.
 * Centraliza operações de CRUD e futuras regras de negócio.
 */
@Service
public class PedidoService {

	private final PedidoRepository repository;

    // Injeção via construtor
	public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    // Cria ou atualiza um pedido
	public Pedido salvar(Pedido pedido) {
	    pedido.setValorTotal(pedido.calcularValorTotal());
	    return repository.save(pedido);
	}



    // Lista todos os pedidos
    public List<Pedido> listar() {
        return repository.findAll();
    }

    // Busca um pedido por ID
    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Deleta um pedido por ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}