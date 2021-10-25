#Spring Boot REST CRUD example

In this tutorial, we're gonna build a Spring Boot Rest CRUD API example with Maven that use Spring Data JPA with H2 database. You'll know:

- Configure Spring Data, JPA, Hibernate to work with H2 Database
- Define Data Models and Repository interfaces
- Create Spring Rest Controller to HTTP requests
- Use Spring Data JPA

###Technologies

> [H2 Database](https://www.h2database.com/html/quickstart.html)

> [Spring Boot](https://spring.io/projects/spring-boot)

> [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

> [Java 8](https://www.java.com/en/download/help/java8_pt-br.html)

> [REST](https://en.wikipedia.org/wiki/Representational_state_transfer)

###Main Classes

- **PersonController** - Responsible to receive all requests and provides all responses in JSON Format
- **PersonRepository** extends JPARepository - Responsible to make all database operations 
- **Person** - Represents the model entity Person with your attributes.
- **RestCrudSpringBootApplication** - The main class of SpringBoot application


###Run Spring Boot application
```
mvn spring-boot:run
```

###CREATE PERSON

- Open your postman application in **localhost:8080/api/persons**
- METHOD: **POST**
- BODY: raw - type **JSON**

```yaml
{
 "name":"NAME",
 "email": "NAME@gmail.com" 
}
```
###UPDATE PERSON

- Open your postman application in **localhost:8080/api/persons/{ID}**
- METHOD:**PUT**
- BODY: raw - type **JSON**

```yaml
{
 "name":"NAME",
 "email": "NAME@gmail.com",
 "actived": true
}
```
###GET ALL PERSONS

- Open your postman application in **localhost:8080/api/persons/**
- METHOD:**GET**
- BODY: EMPTY

###GET ONLY ACTIVED PERSONS

- Open your postman application in **localhost:8080/api/persons/actived/**
- METHOD:**GET**
- BODY: EMPTY

###DELETE ONE PERSON

- Open your postman application in **localhost:8080/api/persons/{id}**
- METHOD:**DELETE**
- BODY: EMPTY

###DELETE ALL PERSONS

- Open your postman application in **localhost:8080/api/persons/**
- METHOD:**DELETE**
- BODY: EMPTY
