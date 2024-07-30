# Clean Architecture Pizza

## Description
The **Clean Architecture Pizza** repository is a sample application that implements clean architecture principles to manage pizza orders. The goal of the project is to demonstrate how to use clean architecture principles to create a modular, scalable, and maintainable application.

## Main Technologies Used
- **Java**
- **Quarkus** for microservice development.
- **JPA** for data persistence.
- **H2 Database** for local testing.
- **RESTEasy** for creating REST APIs.
- **ModelMapper** for entity and DTO mapping.

## Architecture and Design Patterns
- **Clean Architecture**: Separation of concerns into layers (Domain, Application, Infrastructure).
- **Dependency Inversion**: Use of interfaces and dependency injection to decouple layers.
- **DTOs**: Use of Data Transfer Objects to transfer data between layers.

## Key Features
- **Customer Management**: Create, update, and query customers.
- **Pizza Management**: Create, update, and query pizzas.
- **Order Management**: Create orders, including calculating the total value and validating stock.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/clean-architecture-pizza.git
   cd clean-architecture-pizza
   ./mvnw compile quarkus:dev
   ```
2. Access the application at http://localhost:8080 or http://127.0.0.1:8080/swagger-ui/index.html
