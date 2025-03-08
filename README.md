# Kafka Spring Boot Proof of Concept

## Overview
This project is a proof of concept for integrating Apache Kafka with Spring Boot. It consists of two main components: a Kafka producer and a Kafka consumer. The producer sends messages to a Kafka topic, and the consumer listens to the topic and processes the messages.

## Project Structure
The project is divided into two main modules:
- `kafka.producer`: Contains the Kafka producer application.
- `kafka.consumer`: Contains the Kafka consumer application.

## Prerequisites
- Docker
- Docker Compose
- Java 21
- Maven

## Getting Started

### Build and Run with Docker Compose
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd kafka.spring.boot.proof_of_concept
   ```
2. Build and start the services:
   ```sh
   docker-compose up --build
   ```

### Accessing the Applications
- Kafka Producer: http://localhost:8081
- Kafka Consumer: http://localhost:8082
- Kafka UI: http://localhost:8080

## Configuration

### Kafka Producer
Configuration for the Kafka producer can be found in `kafka.producer/src/main/resources/application.yml`:
```yml
spring:
  kafka:
    bootstrap-servers: kafka:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    properties:
      request.timeout.ms: 5000
```

### Kafka Consumer
Configuration for the Kafka consumer can be found in `kafka.consumer/src/main/resources/application.yml`:
```yml
spring:
  kafka:
    bootstrap-servers: kafka:9092
    consumer:
      group-id: grupo-consumidores
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
```

## Usage

### Sending Messages
To send a message to the Kafka topic, make a POST request to the Kafka producer endpoint:
```sh
curl -X POST http://localhost:8081/messages -d "message=Hello, Kafka!"
```

### Viewing Messages
The Kafka consumer will log the received messages. Check the logs of the Kafka consumer container to see the messages:
```sh
docker logs kafka-consumer
```

## License
This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.

## Author ✍️
Ing. Daniel Quinteros