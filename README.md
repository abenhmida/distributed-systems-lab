# Distributed Systems Lab

A practical engineering laboratory for exploring distributed systems,
event-driven architectures, microservices, Apache Kafka, Apache Cassandra,
resilience, consistency, observability, and scalability.

The goal of this project is not to build another CRUD application.

Instead, this repository explores the engineering challenges that appear
when building and operating distributed systems at scale.

---

## Why this project?

Modern distributed systems introduce challenges that are difficult to
understand through isolated code examples.

This project explores these challenges through practical experiments,
architectural decisions, failure scenarios, performance testing, and
production-oriented implementations.

The focus areas include:

- Distributed systems
- Microservices architecture
- Event-driven architecture
- Apache Kafka
- Apache Cassandra
- Java
- Kotlin
- Resilience patterns
- Distributed transactions
- Eventual consistency
- Observability
- Performance engineering
- Containerization
- Kubernetes

---

## Architecture

The lab is built around a fictional order-processing platform.

The platform consists of several independent services that communicate
through synchronous APIs and asynchronous events.

```text
                         ┌───────────────┐
                         │    Client     │
                         └───────┬───────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │  API Gateway  │
                         └───────┬───────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │ Order Service │
                         └───────┬───────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │ Apache Kafka  │
                         └───────┬───────┘
                                 │
              ┌──────────────────┼──────────────────┐
              │                  │                  │
              ▼                  ▼                  ▼
       Payment Service    Inventory Service   Notification Service
              │                  │
              ▼                  ▼
         PostgreSQL          Cassandra

