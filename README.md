# Hotel Management API - IFSP Capivari

Este repositório contém uma API desenvolvida como trabalho da disciplina de Orientação a Objetos do IFSP Capivari. A API tem como objetivo realizar o gerenciamento de um hotel, permitindo o controle de quartos, hóspedes, reservas, check-ins, check-outs e demais operações relacionadas à gestão hoteleira.

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Validation
- Docker
- AWS (EC2, RDS)
- Terraform

## 🗄️ Banco de Dados

O banco de dados utilizado é o Amazon RDS com PostgreSQL, garantindo alta disponibilidade, escalabilidade e segurança dos dados.

## 🚀 Deploy

O deploy da aplicação é realizado na AWS utilizando infraestrutura como código com Terraform. A aplicação é containerizada com Docker e hospedada em uma instância EC2. O banco de dados é provisionado e gerenciado pelo Amazon RDS.

## 🔧 Funcionalidades da API

- Cadastro, atualização, listagem e remoção de hóspedes
- Gerenciamento de quartos (disponibilidade, categorias, preços, status)
- Criação e controle de reservas (associando hóspedes e quartos)
- Check-in e check-out dos hóspedes
- Controle de status dos quartos (livre, ocupado, manutenção)
- Validações de regras de negócio e integridade dos dados

## 📦 Como Executar Localmente

1. Clone este repositório
2. Configure seu arquivo `.env` ou `application.yml` com as credenciais do banco de dados
3. Execute o comando `./mvnw spring-boot:run` ou rode via sua IDE preferida

## 🐳 Executando com Docker

- Para gerar a imagem: `docker build -t hotel-api .`
- Para executar o container: `docker run -p 8080:8080 --env-file .env hotel-api`

## ☁️ Provisionamento na AWS com Terraform

O provisionamento de infraestrutura na AWS inclui:
- Instância EC2 para hospedagem da aplicação
- Banco de dados PostgreSQL no Amazon RDS
- Security Groups configurados para acesso seguro
- Variáveis configuráveis para ambiente (usuário, senha, região, etc.)

## 🤝 Contribuições

Este projeto foi desenvolvido como trabalho acadêmico, mas contribuições, melhorias e feedbacks são bem-vindos.

