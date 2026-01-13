# 🛒 Loja Virtual

---

## 📌 Sobre o projeto
Este é um projeto de Loja Virtual desenvolvido em Spring Boot, com arquitetura baseada em MVC + Service Layer + Repository Pattern.
O objetivo é criar uma API REST para gerenciar clientes, produtos e pedidos, servindo como portfólio e estudo de boas práticas em Java.

---

## ⚙️ Tecnologias utilizadas
• 	Java 17+
• 	Spring Boot
• 	Spring Data JPA
• 	H2 Database (para testes)
• 	Maven
• 	Postman/Insomnia (para testes de API)

---

com.example.loja

│

├── controller      # Endpoints REST (ClienteController, ProdutoController...)

├── service         # Lógica de negócio (ClienteService, ProdutoService...)

├── repository      # Interfaces JPA (ClienteRepository, ProdutoRepository...)

├── entities        # Entidades JPA (@Entity) -> Cliente, Produto, Pedido

└── seed           # Valores iniciais para teste

---

## 🚀 Como executar

1. 	Clone o repositório:
```git clone https://github.com/seu-usuario/loja-virtual.git```
2. 	Entre na pasta do projeto: 
```cd loja-virtual```
3. 	Execute com Maven:
```mvn spring-boot:run```
4. 	Acesse a aplicação em:
```http://localhost:8080```

---

## 📦 Endpoints principais

- Criar cliente
```POST /clientes```
- Exemplo de JSON:
```{"nome": "George Silva", "email": "george.silva@email.com", "senha": "123456", "endereco": Rua das Palmeiras, 45", "cpf": "12345678900", "telefone": "31999998888"}```
- Listar clientes
```GET /clientes```
- Buscar cliente por ID
```GET /clientes/{id}```
- Deletar cliente
```DELETE /clientes/{id}```

---

## 🧪 Banco de dados H2

- Console disponível em:
```http://localhost:8080/h2-console```
- Configuração padrão:
```JDBC URL: jdbc:h2:mem:loja User: sa Password:```

---

## 👨‍💻 Desenvolvedor
- **George Gonçalves Miranda** — [georgeggmiranda@gmail.com](mailto:georgeggmiranda@gmail.com)  

---

## 📄 Licença
Este projeto não possui licença comercial.  
Uso livre para fins educacionais.