# ADR-004: Use the Outbox Pattern

## Status

Accepted

## Context

A service may need to update its database and publish an event.

For example:

```text
1. Save Order
2. Publish OrderCreated
```

## Decision

The Outbox Pattern will be used.

The service writes the business entity and the event to the same
database transaction.

```text
Database Transaction
       │
       ├── Order
       │
       └── Outbox Event
                │
                ▼
        Outbox Publisher
                │
                ▼
              Kafka
```

## Consequences

### Positive
- Atomic database update and event creation
- Reliable event publishing
- Better recovery after failures

### Negative
- Additional infrastructure
- Outbox cleanup required
- Duplicate events are possible
- Consumers must be idempotent

## Important Principle

The Outbox Pattern provides reliable event publication.

It does not automatically guarantee exactly-once business processing.

Therefore, consumers must be designed to handle duplicate events safely.
