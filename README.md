# Stock Trading App Backend

## Overview

This project is a backend application for a stock trading app built using Spring Boot. It provides functionalities for user management, trading account creation, and stock trading operations. 

## Features

- **User Management**: Create and manage user accounts.
- **Trading Account**: Create trading accounts linked to users with balance management.
- **Stock Trading**: Buy and sell stocks using real-time stock prices.
- **Validation**: Integrated validation for request DTOs.
- **API Integration**: Fetch real-time stock prices using Alpha Vantage API.

## Project Structure

- **Controllers**: Handle API requests.
- **DTOs**: Define request and response structures.
- **Mappers**: Convert between entities and DTOs using MapStruct.
- **Models**: Define database entities.
- **Repositories**: Handle database operations.
- **Services**: Implement business logic.

## Prerequisites

- Java 11+
- Maven
- PostgreSQL

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
spring.datasource.password=password
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

### Stock Trading API

- **POST** `/trade`: Execute a stock trade (buy/sell).
  - Request body:
    ```json
    {
        "userId": "UUID",
        "symbol": "String",
        "quantity": "int",
        "tradeType": "TradeType"
    }
    ```

## Contribution

- Fork the repo.
- Create a new branch.
- Commit changes.
- Open a pull request.

## About

This backend application is part of a stock trading app project aimed at showcasing skills in Spring Boot development, API integration, and data validation. Future enhancements include more advanced trading features and portfolio management.

### Resources

- [Alpha Vantage API](https://www.alphavantage.co)
