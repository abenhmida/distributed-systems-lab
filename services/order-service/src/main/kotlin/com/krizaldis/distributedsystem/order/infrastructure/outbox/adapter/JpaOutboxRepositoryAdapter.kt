package com.krizaldis.distributedsystem.order.infrastructure.outbox.adapter

import com.krizaldis.distributedsystem.order.infrastructure.outbox.OutboxRepository
import com.krizaldis.distributedsystem.order.infrastructure.outbox.mapper.OutboxEntityMapper
import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent
import com.krizaldis.distributedsystem.order.infrastructure.outbox.repository.SpringDataOutboxRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.UUID

@Repository
class JpaOutboxRepositoryAdapter(
    private val repository: SpringDataOutboxRepository,
) : OutboxRepository {
    override fun save(event: OutboxEvent) {
        repository.save(
            OutboxEntityMapper.toEntity(event)
        )
    }

    override fun findPending(limit: Int): List<OutboxEvent> {
        return repository.findPending(
            PageRequest.of(0, limit)
        ).map(
            OutboxEntityMapper::toDomain
        )
    }

    override fun markPublished(id: UUID, publishedAt: Instant) {
        repository.findById(id).ifPresent {

            it.publishedAt = publishedAt
            it.updatedAt = Instant.now()

            repository.save(it)
        }
    }

    override fun scheduleRetry(event: OutboxEvent) {
        repository.save(
            OutboxEntityMapper.toEntity(event)
        )
    }
}