# 🛒 Loja Virtual

---

## 📌 Sobre o projeto
Este é um projeto de Loja Virtual desenvolvido em Spring Boot, com arquitetura baseada em MVC + Service Layer + Repository Pattern.
O objetivo é criar uma API REST para gerenciar clientes, produtos e pedidos, servindo como portfólio e estudo de boas práticas em Java.

---

## ⚙️ Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (para testes)
- Maven
- Postman/Insomnia (para testes de API)

---

## 📦 Estrutura do projeto

```
│
├── dto             #
├── controller      # Endpoints REST (ClienteController, ProdutoController...)
├── service         # Lógica de negócio (ClienteService, ProdutoService...)
├── repository      # Interfaces JPA (ClienteRepository, ProdutoRepository...)
├── entities        # Entidades JPA (@Entity) -> Cliente, Produto, Pedido
└── seed           # Valores iniciais para teste
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