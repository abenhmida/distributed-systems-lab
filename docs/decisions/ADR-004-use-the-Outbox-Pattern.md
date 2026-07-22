# ADR-004: Use the Outbox Pattern

## Status

Accepted

## Context

A service may need to update its database and publish an event.

For example:

```text
1. Save Order
2. Publish OrderCreated
