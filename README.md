# 🔗 Encurtador de URL

Este projeto é um encurtador de URLs desenvolvido com **Spring Boot** e empacotado com **Docker**. Ele permite criar URLs curtas a partir de links longos, útil para compartilhamento em redes sociais, mensagens, etc.

---

## 🚀 Tecnologias usadas

- [Java 17](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [NanoId](https://github.com/aventrix/nanoid-java) (para geração dos IDs curtos)

---

## 📦 Como rodar o projeto

### 🐳 Usando Docker

> Certifique-se de ter o [Docker](https://docs.docker.com/get-docker/) instalado.

```bash
# Build da imagem
docker build -t encurtador-url .

# Executar o container
docker run -p 8080:8080 encurtador-url
```

⚙️ Configuração do banco de dados
A aplicação espera que um banco de dados (PostgreSQL, por exemplo) esteja disponível.

Exemplo de configuração (application.properties):
```bash
spring.datasource.url=jdbc:postgresql://<host>:5432/encurtador
spring.datasource.username=usuario
spring.datasource.password=senha
```
spring.jpa.hibernate.ddl-auto=update` 
