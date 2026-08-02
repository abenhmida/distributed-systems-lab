# ADR-002: Use Apache Cassandra for Distributed Storage

## Status

Accepted

## Context

Some parts of the system require a highly scalable distributed datastore.

The expected workload includes:

- High write throughput
- Large data volumes
- Horizontal scalability
- High availability
- Query-driven data access

---

## Decision

Apache Cassandra will be used for selected distributed workloads.

Cassandra is particularly suitable for workloads where:

- Access patterns are known
- Data can be modeled around queries
- High availability is important
- Horizontal scalability is required

---

## Alternatives

### PostgreSQL

PostgreSQL remains the preferred choice for strongly relational
transactional workloads.

However, scaling PostgreSQL horizontally introduces additional
architectural considerations.

### MongoDB

MongoDB provides flexible document-oriented storage.

However, the project specifically wants to explore Cassandra's
distributed data model and consistency mechanisms.

---

## Consequences

### Positive

- Horizontal scalability
- High availability
- Distributed architecture
- High write throughput

### Negative

- Query-driven data modeling
- Limited ad-hoc querying
- Eventual consistency considerations
- Operational complexity
- Data duplication may be necessary

---

## Important Principle

Cassandra tables will be designed based on application queries.

The project will avoid attempting to model Cassandra like a relational
database.

---

## Related Topics

- Partition keys
- Clustering columns
- Replication
- Consistency levels
- Compaction
- Tombstones
- Hot partitions
