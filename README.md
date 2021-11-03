# Spring Boot REST CRUD example

In this tutorial, we're gonna build a Spring Boot Rest CRUD API example with Maven that use Spring Data JPA with H2 database. You'll know:

- Configure Spring Data, JPA, Hibernate to work with H2 Database
- Define Data Models and Repository interfaces
- Create Spring Rest Controller to HTTP requests
- Use Spring Data JPA

### Technologies

> [H2 Database](https://www.h2database.com/html/quickstart.html)

> [Spring Boot](https://spring.io/projects/spring-boot)

> [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

> [Java 8](https://www.java.com/en/download/help/java8_pt-br.html)

> [REST](https://en.wikipedia.org/wiki/Representational_state_transfer)

### Main Classes

- **PersonController** - Responsible to receive all requests and provides all responses in JSON Format
- **PersonRepository** extends JPARepository - Responsible to make all database operations 
- **Person** - Represents the model entity Person with your attributes.
- **RestCrudSpringBootApplication** - The main class of SpringBoot application

### DATABASE Configurations

- application.properties - all database configurations 
- To acess de database console - **localhost:8080/h2-console**
- JDBC URL:	jdbc:h2:mem:restcrud
- User Name:	admin
- Password:	admin


### Run Spring Boot application
```
mvn spring-boot:run
```
> Download [POSTMAN](https://www.postman.com/downloads/) for JSON requests.

### CREATE PERSON

- Open your postman application in **localhost:8080/api/persons**
- METHOD: **POST**
- BODY: raw - type **JSON**

```yaml
{
 "name":"NAME",
 "email": "NAME@gmail.com" 
}
```
- RETURN
```yaml
{
    "id": 1,
    "name": "NAME",
    "email": "NAME@gmail.com",
    "actived": false
}
```

### UPDATE PERSON

- Open your postman application in **localhost:8080/api/persons/{id}**
- METHOD:**PUT**
- BODY: raw - type **JSON**
- ID: 1

```yaml
{
 "name":"NAME",
 "email": "NAME@gmail.com",
 "actived": true
}
```
- RETURN

```yaml
{
    "id": 1,
    "name": "NAME",
    "email": "NAME@gmail.com",
    "actived": true
}
```

### GET ALL PERSONS

- Open your postman application in **localhost:8080/api/persons/**
- METHOD:**GET**
- BODY: EMPTY
- RETURN
```yaml
[
    {
        "id": 1,
        "name": "NAME",
        "email": "NAME@gmail.com",
        "actived": true
    },
    {
        "id": 2,
        "name": "NAME2",
        "email": "NAME2@gmail.com",
        "actived": false
    },
    {
        "id": 3,
        "name": "NAME3",
        "email": "NAME3@gmail.com",
        "actived": false
    }
]
```

### GET ONLY ACTIVED PERSONS

- Open your postman application in **localhost:8080/api/persons/actived/**
- METHOD:**GET**
- BODY: EMPTY

```yaml
[
    {
        "id": 1,
        "name": "NAME",
        "email": "NAME@gmail.com",
        "actived": true
    }
]
```
### GET PERSONS BY EMAIL FILTER

- Open your postman application in **localhost:8080/api/persons?email={query}**
- METHOD:**GET**
- BODY: EMPTY
- email: 2

- RETURN
```yaml
[
    {
        "id": 2,
        "name": "NAME2",
        "email": "NAME2@gmail.com",
        "actived": false
    }
]
```

### DELETE ONE PERSON

- Open your postman application in **localhost:8080/api/persons/{id}**
- METHOD:**DELETE**
- BODY: EMPTY
- RETURN: **204 No Content**

### DELETE ALL PERSONS

- Open your postman application in **localhost:8080/api/persons/**
- METHOD:**DELETE**
- BODY: EMPTY
- RETURN: **204 No Content**
