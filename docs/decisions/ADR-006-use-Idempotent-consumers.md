# ADR-006: Use Idempotent Consumers

## Status

Accepted

## Context

Kafka consumers may receive the same event more than once.

For example:

```text
OrderCreated
OrderCreated
```
## Decision

All business-critical Kafka consumers will be designed to be idempotent.

A consumer will track processed event identifiers.
```text

             Event
               │
               ▼
       ┌─────────────────┐
       │ Already Processed│
       └────────┬────────┘
                │
          ┌─────┴─────┐
          │           │
         YES          NO
          │           │
          ▼           ▼
        Ignore      Process
                      │
                      ▼
               Mark Processed
```

## Consequences

### Positive
- Safe retry behavior
- Resilience against duplicate events
- Reliable at-least-once processing

### Negative
- Additional storage
- Additional processing
- Idempotency state must be managed

##Important Principle

At-least-once message delivery requires business operations
to be safe when executed multiple times.

**Idempotency** is therefore treated as a core architectural concern.
