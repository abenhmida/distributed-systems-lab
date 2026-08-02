# ADR-005: Use the Saga Pattern

## Status

Accepted

## Context

The order workflow spans multiple services.

Example:

```text
Order
  │
  ▼
Payment
  │
  ▼
Inventory
```

A traditional distributed transaction would be complex and
tightly coupled.

## Decision

The Saga Pattern will be used to coordinate distributed business
transactions.

Each service performs a local transaction.

If a later step fails, compensating actions are executed.

## Example:
```text
Order Created
     │
     ▼
Payment Completed
     │
     ▼
Inventory Reservation Failed
     │
     ▼
Compensating Action
     │
     ▼
Payment Refunded
```
