# ADR-001: Use Apache Kafka for Event Streaming

## Status

Accepted

## Context

The platform contains multiple independent services that need to
communicate asynchronously.

The system should support:

- High event throughput
- Horizontal scalability
- Event replay
- Independent consumers
- Durable event retention

A messaging platform is therefore required.

---

## Decision

Apache Kafka will be used as the primary event streaming platform.

Kafka provides:

- Durable event storage
- Consumer groups
- Partition-based scalability
- Event replay
- High throughput

---

## Alternatives

### REST

REST is simple and widely understood.

However, synchronous HTTP communication introduces temporal coupling.

If the receiving service is unavailable, the caller may fail.

REST is therefore not the primary mechanism for business event propagation.

### RabbitMQ

RabbitMQ provides a strong messaging model and flexible routing.

However, the project places particular emphasis on:

- Event retention
- Replay
- Partition-based scaling
- High-throughput event streaming

Kafka is a better fit for these requirements.

---

## Consequences

### Positive

- High throughput
- Event replay
- Consumer independence
- Horizontal scalability
- Loose coupling

### Negative

- Operational complexity
- Partitioning must be designed carefully
- Schema evolution must be managed
- Debugging asynchronous workflows is more complex

---

## Related Decisions

- ADR-003: Event-Driven Communication
- ADR-004: Outbox Pattern
- ADR-006: Idempotent Consumers
