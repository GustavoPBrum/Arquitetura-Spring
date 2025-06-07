# API de Produtos

Este repositório contém o projeto **API de Produtos**, desenvolvido como parte do curso **Spring Boot Expert**. A aplicação é uma API RESTful para gerenciamento de produtos, incluindo funcionalidades de cadastro, consulta, atualização e exclusão de dados.

---

## 📑 Funcionalidades
- Cadastro de produtos.
- Consulta de produtos (individual e lista).
- Atualização de informações de produtos.
- Exclusão de produtos.
- Validação de dados e tratamento de erros.

---

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**: Persistência de dados.
- **H2 Database**: Banco de dados em memória para testes locais.
- **Bean Validation**: Validação de dados do modelo.
- **Spring Web**: Implementação de endpoints RESTful.
- **Swagger/OpenAPI**: Documentação interativa da API.

---

## 📚 Endpoints da API

### **Produtos**
- `GET /api/produtos`  
  Retorna a lista de todos os produtos.

- `GET /api/produtos/{id}`  
  Retorna os detalhes de um produto específico.

- `POST /api/produtos`  
  Cadastra um novo produto.  
  **Exemplo de payload**:  
