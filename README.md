# 📦 Nome do Projeto

> Projeto desenvolvido em Java utilizando Spring Boot e arquitetura Hexagonal (Ports and Adapters).

## 🚀 Visão Geral

Este projeto tem como objetivo demonstrar a aplicação da **Arquitetura Hexagonal (Ports & Adapters)** com **Java 17** e **Spring Boot 3.x**, promovendo separação de responsabilidades, independência de frameworks e alta testabilidade.

---

## 📐 Arquitetura Hexagonal

A estrutura é baseada nos seguintes conceitos:

- **Core Domain (Domínio):** onde vivem as regras de negócio (Entidades, Casos de Uso, Portas).
- **Inbound Adapters (Entrada):** responsáveis por receber as requisições (Controllers REST, Mensageria).
- **Outbound Adapters (Saída):** responsáveis por se comunicar com o mundo externo (Banco de Dados, APIs externas).
- **Ports:** interfaces que conectam o domínio com o exterior (Input/Output).


---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Maven ou Gradle
- JUnit + Mockito
- MapStruct (opcional)
- PostgreSQL ou H2 (ambiente de testes)

---

## ▶️ Como Executar o Projeto

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/seu-projeto.git
cd seu-projeto

# Executar com Maven
./mvnw spring-boot:run

# Ou com Gradle
./gradlew bootRun

# Executar testes unitários
./mvnw test
# Ou
./gradlew test

📌 Exemplos de Endpoints
GET /api/v1/clientes

POST /api/v1/clientes

GET /api/v1/clientes/{id}


Quer que eu gere também os *templates* de código com estrutura inicial hexagonal? Posso fazer isso agora.

[Click here to try a new GPT!](https://f614.short.gy/Code)
