# 🛒 Loja Virtual

---

## 📌 Sobre o projeto
Este é um projeto de Loja Virtual desenvolvido em Spring Boot, com arquitetura baseada em MVC + Service Layer + Repository Pattern.
O objetivo é criar uma API REST para gerenciar clientes, produtos e pedidos, servindo como portfólio e estudo de boas práticas em Java.

---

## ⚙️ Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (para testes)
- Maven
- Postman/Insomnia (para testes de API)
- Spring Security

---

## 📦 Estrutura do projeto

```
│
├── config                  # Configurações globais do projeto
│   ├── ModelMapperConfig.java   # Bean para conversão entre entidades e DTOs
│   └── SecurityConfig.java      # Configuração do Spring Security (autenticação/autorização)
│
├── controller              # Camada de apresentação (endpoints REST)
│   ├── ClienteController.java   # Endpoints relacionados a Cliente
│   ├── PedidoController.java    # Endpoints relacionados a Pedido
│   └── ProdutoController.java   # Endpoints relacionados a Produto
│
├── dto                     # Objetos de transferência de dados (DTOs)
│   ├── ClienteDTO.java
│   ├── PedidoDTO.java
│   └── ProdutoDTO.java
│
├── entity                  # Classe que representa uma tabela no banco de dados.
│   ├── Cliente.java             # Entidade JPA Cliente
│   ├── Pedido.java              # Entidade JPA Pedido
│   └── Produto.java             # Entidade JPA Produto
│
├── repository              # Interfaces JPA (camada de persistência)
│   ├── ClienteRepository.java
│   ├── PedidoRepository.java
│   └── ProdutoRepository.java
│
├── seed                    # Dados iniciais para popular o banco (fixtures)
│   └── SeedData.java
│
└── service                 # Camada de negócio (regras e lógica)
    ├── ClienteService.java
    ├── PedidoService.java
    └── ProdutoService.java
```

---

## 🌱 Dados iniciais (Seed)
Ao iniciar a aplicação, são inseridos automaticamente:
- 3 clientes (Joaquim, Maria, João)
- 3 produtos (Notebook Dell, Smartphone Samsung, Monitor LG)
- 2 pedidos de exemplo (associados a clientes e produtos)

---

## 🚀 Como executar

1. 	Clone o repositório:
```
git clone https://github.com/seu-usuario/loja-virtual.git
```
2. 	Entre na pasta do projeto: 
```
cd loja-virtual
```
3. 	Execute com Maven:
```
mvn spring-boot:run
```
4. 	Acesse a aplicação em:
```
http://localhost:8080
```

---

🔒 Segurança
O projeto utiliza Spring Security com autenticação Basic Auth:
- Usuário `george/1234` → ROLE_USER
- Usuário `admin/admin` → ROLE_ADMIN

Regras de acesso
- `/pedidos/**` → acessível apenas para ROLE_USER
- `/clientes/**` → acessível apenas para ROLE_ADMIN
- Demais endpoints → requerem autenticação

---

## 📦 Endpoints principais

### Clientes
- Criar cliente
```
POST /clientes
```
- Exemplo de JSON:
```
{
  "nome": "Carlos",
  "email": "carlos@email.com",
  "endereco": "Rua Nova, 123",
  "cpf": "22233344455",
  "telefone": "31966666666"
}
```

- Listar clientes
```
GET /clientes
```
- Buscar cliente por ID
```
GET /clientes/{id}
```
- Deletar cliente
```
DELETE /clientes/{id}
```

### Produtos
- Listar produtos
```
GET /produtos
```
- Criar produto
```
POST /produtos
```
- Buscar produto por ID
```
GET /produtos/{id}
```

### Pedidos
- Listar pedido
```
GET /pedidos
```
- Criar pedido
```
POST /pedidos
```
- Buscar pedido por ID
```
GET /pedidos/{id}
```

---

## 🧪 Banco de dados H2

- Console disponível em:
```
http://localhost:8080/h2-console
```
- Configuração padrão:
```
JDBC URL: jdbc:h2:mem:loja User: sa Password:
```

---

## 👨‍💻 Desenvolvedor
- **George Gonçalves Miranda** — [georgeggmiranda@gmail.com](mailto:georgeggmiranda@gmail.com)  

---

## 📄 Licença
Este projeto não possui licença comercial. Uso livre para fins educacionais.