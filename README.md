# Stock Trading App Backend

## Overview
A Spring Boot application for managing user accounts and trading accounts with integrated validation and mapping.

## Features
- User creation and validation.
- Trading account creation linked to users.
- DTOs and MapStruct for efficient data handling.

## Project Structure
- **Controllers**: Handle API requests.
- **DTOs**: Define request and response structures.
- **Mappers**: Convert between entities and DTOs.
- **Models**: Define database entities.
- **Repositories**: Handle database operations.
- **Services**: Implement business logic.

## Prerequisites
- **Java 11+**
- **Maven**
- **PostgreSQL**

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/aryang112/stocktradingapp.git
cd stocktradingapp
```

### 2. Configure Database
Update `src/main/resources/application.properties` with your PostgreSQL details:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password={{password}}
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database=POSTGRESQL
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### 3. Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### User API
- **POST** `/createUser`: Create a new user.
- **GET** `/readUser/{id}`: Retrieve user details by ID.

### Trading Account API
- **POST** `/createTradingAccount`: Create a new trading account.
- **GET** `/readTradingAccount/{userId}`: Retrieve trading account details by User ID.

## Contribution
- Fork the repo.
- Create a new branch.
- Commit changes.
- Open a pull request.
