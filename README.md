# CondoControl API

API REST para gerenciamento de condomínios.

O objetivo deste projeto é servir como **estudo de arquitetura moderna em aplicações Java**, aplicando boas práticas como:

* Clean Architecture
* Domain Driven Design (DDD)
* Arquitetura em camadas
* Separação de responsabilidades
* Boas práticas de API REST

---

# 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* Lombok
* Maven
* PostgreSQL (ou H2 para testes)

---

# 📁 Estrutura do Projeto

O projeto segue uma organização baseada em **módulos e responsabilidades**, inspirada em Clean Architecture.

```
src/main/java
└── io.github.carlosacavalcante.condocontrol
    ├── config
    │   └── SecurityConfig
    │
    ├── modules
    │   └── condominio
    │       ├── application
    │       │   └── usecase
    │       │       └── CriarCondominioUseCase
    │       │
    │       ├── domain
    │       │   ├── model
    │       │   │   └── Condominio
    │       │   │
    │       │   ├── repository
    │       │   │   └── CondominioRepository
    │       │   │
    │       │   └── service
    │       │
    │       ├── infrastructure
    │       │   ├── persistence
    │       │   │   ├── entity
    │       │   │   │   └── CondominioEntity
    │       │   │   │
    │       │   │   ├── repository
    │       │   │   │   ├── JpaCondominioRepository
    │       │   │   │   └── CondominioRepositoryImpl
    │       │   │   │
    │       │   │   └── mapper
    │       │   │       └── CondominioMapper
    │       │
    │       └── presentation
    │           ├── controller
    │           │   └── CondominioController
    │           │
    │           └── dto
    │               └── CondominioRequestDTO
```

---

# 🧱 Arquitetura

A aplicação segue os princípios da **Clean Architecture**, separando responsabilidades em camadas.

## Domain

Contém as regras de negócio principais.

Exemplos:

* Entidades de domínio
* Interfaces de repositório
* Serviços de domínio

---

## Application

Camada responsável por **orquestrar os casos de uso da aplicação**.

Exemplos:

* Criar condomínio
* Atualizar condomínio
* Buscar condomínio

---

## Infrastructure

Responsável por integrações externas:

* Banco de dados
* Implementação de repositórios
* Mapeamento JPA

---

## Presentation

Camada responsável pela **exposição da API REST**.

Contém:

* Controllers
* DTOs
* Validações de entrada

---

# 📌 Funcionalidades atuais

* Criar condomínio
* Persistir dados no banco
* Estrutura baseada em arquitetura limpa

---

# 📚 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

* estudo de arquitetura backend profissional
* boas práticas em APIs REST
* organização de código em projetos escaláveis

---

# 👨‍💻 Autor

Carlos A. Cavalcante

GitHub:
https://github.com/carlosacavalcante
