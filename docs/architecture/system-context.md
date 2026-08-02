# System Context

## Context

The Order Processing Platform allows clients to create and track orders.

The platform integrates several independent services.

```text
                         ┌──────────────┐
                         │    Client    │
                         └──────┬───────┘
                                │
                                ▼
                  ┌─────────────────────────┐
                  │ Order Processing System │
                  └────────────┬────────────┘
                               │
             ┌─────────────────┼─────────────────┐
             │                 │                 │
             ▼                 ▼                 ▼
        Payment System   Inventory System   Notification System
