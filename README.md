<h1 align="center">📚 LiterAlura - Challenge Java</h1>

<p align="center">
  <em>Desafio Java + Spring Boot + PostgreSQL | API Gutendex</em>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-orange" alt="Java">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.3-brightgreen" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Maven-4%2B-blue" alt="Maven">
  <img src="https://img.shields.io/badge/PostgreSQL-16%2B-blue" alt="PostgreSQL">
  </p>

---

## 🚀 Sobre o Projeto
O **LiterAlura** é um desafio de programação em **Java**, utilizando **Spring Boot**, **PostgreSQL** e integração com a **API Gutendex**, que fornece dados de mais de 70 mil livros do *Project Gutenberg*.  
O objetivo é construir um catálogo de livros e autores com funcionalidades de **busca**, **listagem** e **estatísticas**, salvando tudo no banco de dados.

---

## 🛠️ Tecnologias Utilizadas

- ☕ **Java JDK**: 17 ou superior  
- 📦 **Maven**: 4 ou superior  
- 🌱 **Spring Boot**: 3.2.3  
- 🗄️ **PostgreSQL**: 16 ou superior  
- 💻 **IDE**: IntelliJ IDEA *(opcional)*  

🔗 **Links úteis**
- [📥 Download Java LTS](https://www.oracle.com/java/technologies/downloads/)
- [🚀 Spring Initializr](https://start.spring.io/)
- [🐘 Download PostgreSQL](https://www.postgresql.org/download/)
- [🖥️ IntelliJ IDEA](https://www.jetbrains.com/idea/)

---

## ⚙️ Configuração do Projeto

**Parâmetros ao criar no Spring Initializr**
- Linguagem: Java  
- Versão Java: 17+  
- Empacotamento: JAR  
- Gerenciador: Maven  
- Spring Boot: 3.4.8  

**Dependências iniciais**
- Spring Data JPA  
- PostgreSQL Driver  

---

## 🌐 API Utilizada
- **[Gutendex API](https://gutendex.com/)** — Catálogo de livros gratuitos do *Project Gutenberg*.
- Não precisa de token de acesso.
- [📂 Repositório oficial da API](https://github.com/garethbjohnson/gutendex)

---

## 📌 Funcionalidades

✅ **Consultar Livros**
- Buscar por título
- Listar todos os livros salvos
- Filtrar por idioma

✅ **Consultar Autores**
- Listar autores salvos
- Consultar autores vivos em um ano específico

✅ **Persistência de Dados**
- Salvar livros e autores no banco
- Relacionamento Livro ↔ Autor

✅ **Estatísticas**
- Quantidade de livros por idioma

---

## 🔍 Fluxo de Desenvolvimento

1️⃣ **Configuração do ambiente** (Java, Maven, Spring Boot, PostgreSQL)  
2️⃣ **Conhecendo a API Gutendex** (requisições de teste)  
3️⃣ **HttpClient, HttpRequest e HttpResponse** para consumir a API  
4️⃣ **Jackson** para analisar JSON e mapear para objetos Java  
5️⃣ **Conversão de dados** para classes `Livro` e `Autor`  
6️⃣ **Menu interativo** no console com `Scanner`  
7️⃣ **Consultas e filtros** para livros e autores  
8️⃣ **Persistência** com Spring Data JPA  
9️⃣ **Estatísticas** com Streams e consultas derivadas  

---

## 🗄️ Modelo do Banco de Dados

**📚 Tabela Livro**
- id  
- título  
- idioma  
- número de downloads  
- autor_id   

**✍️ Tabela Autor**
- id  
- nome  
- ano_nascimento  
- ano_falecimento  

---
:octocat:   SOBRE A DESENVOLVEDORA  

![Isabela Marques](https://github.com/user-attachments/assets/76a8e0d4-8a08-45cd-9e9b-18f70cc0122c)

🎓 Isabela Cavalcante Marques  
💼 Estudante no programa Oracle ONE + Alura  
🌐 GitHub: [@Isabelaestuda](https://github.com/Isabelaestuda)  

---

Este projeto foi desenvolvido para fins educacionais no Programa ONE - Oracle Next Education em parceria com a Alura.
<p align="center">Feito com 💙 e ☕ em Java</p>

---
## ▶️ Como Executar
---

```bash
# 1. Clonar o repositório
git clone https://github.com/seu-usuario/literalura.git

# 2. Criar banco no PostgreSQL
CREATE DATABASE literalura;

# 3. Configurar credenciais no application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update

# 4. Rodar a aplicação
mvn spring-boot:run
