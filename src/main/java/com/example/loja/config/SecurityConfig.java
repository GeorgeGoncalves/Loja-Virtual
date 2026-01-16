package com.example.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// Bean para codificação de senhas
	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
    // Define usuários em memória (apenas para testes)
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder encoder) {
	    UserDetails user = User.builder()
	            .username("george")
	            .password(encoder.encode("1234")) // senha criptografada
	            .roles("USER")
	            .build();

	    UserDetails admin = User.builder()
	            .username("admin")
	            .password(encoder.encode("admin")) // senha criptografada
	            .roles("ADMIN")
	            .build();

	    return new InMemoryUserDetailsManager(user, admin);
	}

    // Configura regras de acesso
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/pedidos/**").hasRole("USER")
                                .requestMatchers("/clientes/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}); // habilita autenticação básica (Postman, curl)
    return http.build();
    }
}