# ADR-003: Use Event-Driven Communication

## Status

Accepted

## Context

The initial system uses synchronous service-to-service communication.

This introduces temporal coupling.

For example:

```text
Order Service
      │
      ▼
Payment Service

## Decision

Business events will be propagated asynchronously through Kafka.

## Example:

```text
Order Service
      │
      ▼
OrderCreated
      │
      ▼
Kafka
      │
      ├──────► Payment Service
      │
      ├──────► Inventory Service
      │
      └──────► Notification Service
