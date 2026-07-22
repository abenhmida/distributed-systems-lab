
# Architecture Overview

## Purpose

The Distributed Systems Lab is centered around a fictional
order-processing platform.

The purpose of the platform is to demonstrate how a distributed system
can evolve from a simple synchronous architecture into a resilient,
event-driven architecture.


## Business Domain

The platform processes customer orders.

An order goes through several stages:

1. Order creation
2. Payment processing
3. Inventory reservation
4. Order confirmation
5. Notification

Each stage is represented by a separate service.


## Initial Architecture

The initial architecture uses synchronous HTTP communication.

```text
Client
  │
  ▼
Order Service
  │
  ▼
Payment Service
  │
  ▼
Inventory Service
