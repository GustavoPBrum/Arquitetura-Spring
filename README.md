# Arquitetura Spring

Este repositório contém o projeto **Arquitetura Spring**, desenvolvido no módulo 3 do curso **Spring Boot Expert**. O projeto explora a organização e os componentes principais do Spring Framework, aplicando conceitos de arquitetura limpa e boas práticas.

---

## 📑 Objetivos do Projeto
- Demonstrar a separação de responsabilidades em camadas (Controller, Service e Repository).
- Aplicar o padrão DTO para troca de dados entre as camadas.
- Explorar a utilização de dependências e injeção de dependência no Spring.
- Implementar uma arquitetura escalável e de fácil manutenção.

---

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring Web**: Criação de APIs REST.
- **Spring Data JPA**: Persistência e manipulação de dados.
- **H2 Database**: Banco de dados em memória para testes locais.
- **Bean Validation**: Validação de dados.
- **Lombok**: Redução de boilerplate no código.

---

## 📚 Estrutura do Projeto

### Camadas
- **Controller**: Responsável por receber as requisições HTTP e retornar as respostas adequadas.
- **Service**: Contém as regras de negócio.
- **Repository**: Gerencia a comunicação com o banco de dados.

---

## 📖 Conceitos Aplicados
- **Inversão de Controle e Injeção de Dependência**
  - Uso do Spring para gerenciar as dependências entre componentes.
- **Padrão DTO (Data Transfer Object)**
  - Abstração para enviar e receber dados sem expor as entidades diretamente.
- **Boas práticas de organização**
  - Código limpo, reutilizável e de fácil entendimento.

---
