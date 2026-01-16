package com.example.loja.service;

import com.example.loja.dto.PedidoDTO;
import com.example.loja.entity.Cliente;
import com.example.loja.entity.Pedido;
import com.example.loja.entity.Produto;
import com.example.loja.entity.StatusPedido;
import com.example.loja.repository.ClienteRepository;
import com.example.loja.repository.PedidoRepository;
import com.example.loja.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

	private final PedidoRepository repository;
	private final ClienteRepository clienteRepository;
	private final ProdutoRepository produtoRepository;

	public PedidoService(PedidoRepository repository, ClienteRepository clienteRepository,
			ProdutoRepository produtoRepository) {
		this.repository = repository;
		this.clienteRepository = clienteRepository;
		this.produtoRepository = produtoRepository;
	}

	// Converte uma entidade Pedido em um PedidoDTO para resposta da API
	public PedidoDTO toDTO(Pedido pedido) {
	    PedidoDTO dto = new PedidoDTO(); // cria um novo DTO

	    // Define o ID do pedido (vem do banco)
	    dto.setId(pedido.getId());

	    // Define o ID do cliente associado ao pedido
	    dto.setClienteId(pedido.getCliente() != null ? pedido.getCliente().getId() : null);

	    // Define a lista de IDs dos produtos associados ao pedido
	    dto.setProdutosIds(
	        pedido.getProdutos() != null
	            ? pedido.getProdutos().stream().map(Produto::getId).toList()
	            : null
	    );

	    // Define a data do pedido
	    dto.setDataPedido(pedido.getDataPedido());

	    // Define o valor total do pedido
	    dto.setValorTotal(pedido.getValorTotal());

	    // Define o status do pedido (enum)
	    dto.setStatus(pedido.getStatus());

	    return dto; // retorna o DTO pronto para ser serializado em JSON
	}

	// Converte um PedidoDTO em uma entidade Pedido pronta para salvar no banco
	public Pedido fromDTO(PedidoDTO dto) {
	    Pedido pedido = new Pedido(); // cria um novo objeto Pedido

	    // Define a data do pedido a partir do DTO
	    pedido.setDataPedido(dto.getDataPedido());

	    // Busca o cliente no banco pelo ID recebido no DTO
	    Cliente cliente = clienteRepository.findById(dto.getClienteId())
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + dto.getClienteId()));
	    pedido.setCliente(cliente); // associa o cliente ao pedido

	    // Busca os produtos no banco pelos IDs recebidos no DTO
	    List<Produto> produtos = produtoRepository.findAllById(dto.getProdutosIds());
	    if (produtos.size() != dto.getProdutosIds().size()) {
	        throw new RuntimeException("Um ou mais produtos não foram encontrados: " + dto.getProdutosIds());
	    }
	    pedido.setProdutos(produtos); // associa os produtos ao pedido

	    // Calcula o valor total somando os preços dos produtos
	    double total = produtos.stream()
	            .mapToDouble(p -> p.getPreco() != null ? p.getPreco() : 0.0)
	            .sum();
	    pedido.setValorTotal(total);

	    // Define o status do pedido
	    // Se o DTO trouxe um status, usa ele; senão, define como PENDENTE
	    if (dto.getStatus() != null) {
	        pedido.setStatus(dto.getStatus()); // usa o enum diretamente
	    } else {
	        pedido.setStatus(StatusPedido.PENDENTE);
	    }

	    return pedido; // retorna o Pedido pronto
	}

	// Criar pedido
	public Pedido save(Pedido pedido) {
		return repository.save(pedido);
	}

	// Listar pedidos
	public List<Pedido> findAll() {
		return repository.findAll();
	}

	// Buscar pedido por Id
	public Pedido findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException(
				"Pedido não encontrado com id: " + id));
	}

	// Deletar pedido por Id
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	// Cria e salva um pedido a partir do DTO
	public Pedido saveFromDTO(PedidoDTO dto) {
	    Pedido pedido = fromDTO(dto); // reaproveita o método que já monta o Pedido
	    return repository.save(pedido); // salva no banco
	}
}