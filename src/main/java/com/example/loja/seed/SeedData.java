package com.example.loja.seed;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.loja.entities.Cliente;
import com.example.loja.entities.Pedido;
import com.example.loja.entities.Produto;
import com.example.loja.entities.StatusPedido;
import com.example.loja.repository.ClienteRepository;
import com.example.loja.repository.PedidoRepository;
import com.example.loja.repository.ProdutoRepository;

@Configuration
//Indica que esta classe contém configurações do Spring (beans).
public class SeedData {

	@Bean
	// Define um bean do tipo CommandLineRunner, que é executado automaticamente
	// quando a aplicação inicia. Serve para inserir dados iniciais no banco.
	CommandLineRunner initDatabase(ClienteRepository clienteRepository, ProdutoRepository produtoRepository,
			PedidoRepository pedidoRepository) {
		return args -> {

			// ---- Clientes ----
			// Cada chamada de save() insere um cliente no banco H2.
			clienteRepository.save(new Cliente("Joaquim", "joaquim@email.com", "123456", "Rua das Flores, 123",
					"12345678900", "31999999999"));
			clienteRepository.save(new Cliente("Maria", "maria@email.com", "abcdef",
					"Av. Brasil, 456", "98765432100", "31988888888"));
			clienteRepository.save(new Cliente("João", "joao@email.com", "senha123", "Praça Central, 789",
					"11122233344", "31977777777"));

			// ---- Produtos ----
			// Cada chamada de save() insere um produto no banco H2.
			produtoRepository.save(new Produto("Notebook Dell Inspiron",
					"Notebook Dell Inspiron 15, Intel i7, 16GB RAM, SSD 512GB", 4999.90, 10));
			produtoRepository.save(new Produto("Smartphone Samsung Galaxy S23",
					"Celular Samsung Galaxy S23, 256GB, câmera tripla", 3999.00, 25));
			produtoRepository.save(new Produto("Monitor LG Ultrawide",
					"Monitor LG Ultrawide 34 polegadas, resolução 3440x1440", 1899.00, 15));

			// ---- Pedidos ----
			Cliente joao = clienteRepository.findById(3L).orElseThrow();
			Cliente maria = clienteRepository.findById(2L).orElseThrow();

			Produto notebook = produtoRepository.findById(1L).orElseThrow();
			Produto smartphone = produtoRepository.findById(2L).orElseThrow();
			Produto monitor = produtoRepository.findById(3L).orElseThrow();

			// Cria pedidos relacionando cliente e produtos
			Pedido pedido1 = new Pedido(
				    joao,
				    Arrays.asList(notebook, monitor),
				    LocalDateTime.now()
				    , StatusPedido.PENDENTE
				);

				Pedido pedido2 = new Pedido(
				    maria,
				    Arrays.asList(smartphone),
				    LocalDateTime.now(),
				    StatusPedido.PAGO
				);

				pedidoRepository.save(pedido1);
				pedidoRepository.save(pedido2);


		};
	}
}