# Microservice responsible for manage creches

Technologies used: 
- Spring Boot
- Spring MVC
- Spring Data
- Lombok
- MySQL
- Swagger
- Docker
- Docker Compose

## Project Patterns implemented

- Builder

## Pre requirements to run the applications:

- Docker
- Docker Compose

## Setup

### Run the command:

```bash
    docker-compose up
```

That is it. Simple like that.

## URLs and Endpoints

- MySQL Admin: http://localhost:8081
- Documentation (Swagger): http://localhost:8080/swagger-ui.html
- creche-api: http://localhost:8080/creches
- Health Check: http://localhost:8080/actuator