# Gestão de Vagas (Backend)

Aplicação backend em Java Spring Boot para gerenciar candidatos e vagas.

## Visão geral

Projeto mínimo demonstrando:

- Estrutura em Spring Boot
- Validação de dados com Jakarta Validation
- Endpoints REST para criação de candidatos

## Tecnologias

- Java 17
- Spring Boot 3.x
- Maven (wrapper incluído)
- Lombok (para reduzir boilerplate)

## Pré-requisitos

- Java 17 ou superior instalado

## Como rodar

1. Buildar o projeto:

```bash
./mvnw clean package
```

2. Rodar pela task do Spring Boot durante desenvolvimento:

```bash
./mvnw spring-boot:run
```

3. Ou executar o JAR gerado:

```bash
java -jar target/gestao_vagas-0.0.1-SNAPSHOT.jar
```

O aplicativo, por padrão, será executado em `http://localhost:8080`.

## Testes

Executar testes unitários:

```bash
./mvnw test
```
