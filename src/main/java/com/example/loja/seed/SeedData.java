package com.example.loja.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.loja.entities.Cliente;
import com.example.loja.entities.Produto;
import com.example.loja.repository.ClienteRepository;
import com.example.loja.repository.ProdutoRepository;

@Configuration
//Indica que esta classe contém configurações do Spring (beans).
public class SeedData {


    @Bean
    // Define um bean do tipo CommandLineRunner, que é executado automaticamente
    // quando a aplicação inicia. Serve para inserir dados iniciais no banco.
    CommandLineRunner initDatabase(ClienteRepository repository, ProdutoRepository produtoRepository) {
        return args -> {
        	
        	// ---- Clientes ----
        	// Cada chamada de save() insere um cliente no banco H2.
            repository.save(new Cliente(
                "George", "george@email.com", "123456",
                "Rua das Flores, 123", "12345678900", "31999999999"
            ));
            repository.save(new Cliente(
                "Maria", "maria@email.com", "abcdef",
                "Av. Brasil, 456", "98765432100", "31988888888"
            ));
            repository.save(new Cliente(
                "João", "joao@email.com", "senha123",
                "Praça Central, 789", "11122233344", "31977777777"
            ));
            
            // ---- Produtos ----
            // Cada chamada de save() insere um produto no banco H2.
            produtoRepository.save(new Produto(
                    "Notebook Dell Inspiron",
                    "Notebook Dell Inspiron 15, Intel i7, 16GB RAM, SSD 512GB",
                    4999.90,
                    10
                ));
                produtoRepository.save(new Produto(
                    "Smartphone Samsung Galaxy S23",
                    "Celular Samsung Galaxy S23, 256GB, câmera tripla",
                    3999.00,
                    25
                ));
                produtoRepository.save(new Produto(
                    "Monitor LG Ultrawide",
                    "Monitor LG Ultrawide 34 polegadas, resolução 3440x1440",
                    1899.00,
                    15
                ));
        };
    }
}