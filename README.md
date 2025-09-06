# ExpenseService

A microservice designed for fetching, updating, storing, and processing user expense data. It ingests expense messages from users' bank communications using **Kafka**, processes them, and persists them into a database.

##  Features

- **Kafka Integration**: Consumes expense-related messages from bank notifications.
- **Expense Management**: Processes, stores, and updates expense records.
- **Scalable & Extensible**: Built using Spring Boot and Spring Kafka for robust microservice deployment.

##  Quick Guide

###  Prerequisites

- **Docker** and **Docker Compose** (if you're running as containers)
- Or a running **Kafka broker** and **MySQL database**

###  Running with Docker Compose

1. Build the Docker image:
    ```bash
    docker build -t expense-service -f Dockerfile .
    ```
2. Run your service with Docker Compose (adapt the service name if needed)(You can get auth service, user service and data science service from my github):
    ```bash
    docker-compose up -d
    ```

###  Running Locally

1. Ensure Kafka broker and MySQL are running and accessible.
2. Set the correct Kafka and database connection details via `application.properties` or environment variables.
3. Start the service:
    ```bash
    mvn spring-boot:run
    ```
