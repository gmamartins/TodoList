<h1 align="center">
  TODO List
</h1>


API para gerenciar tarefas (CRUD) 

# Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

# Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

# Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

# API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta Insomnia

- Criar Tarefa 
```
$ http POST :8080/todos

[
  {
	"nome": "Comprar pão",
	"descricao": "Ir na padaria e comprar pão português",
	"realizado": false,
	"prioridade": 3
  }
]
```

- Listar Tarefas
```
$ http GET :8080/todos

[
  {
    "id": 1,
	"nome": "Comprar pão",
	"descricao": "Ir na padaria e comprar pão português",
	"realizado": false,
	"prioridade": 3
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8080/todos/1 

[
  {
    "nome": "Comprar café",
	"descricao": "Ir no mercado e comprar café",
	"realizado": false,
	"prioridade": 2
  }
]
```

- Remover Tarefa
```
http DELETE :8080/todos/1

[ ]
```