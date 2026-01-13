package com.example.loja.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.loja.entities.Cliente;
import com.example.loja.repository.ClienteRepository;

@Configuration
public class SeedData {

    @Bean
    CommandLineRunner initDatabase(ClienteRepository repository) {
        return args -> {
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
        };
    }
}