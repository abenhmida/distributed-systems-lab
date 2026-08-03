package com.krizaldis.distributedsystem.order.infrastructure.outbox

import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent
import java.time.Instant
import java.util.UUID

interface OutboxRepository {
    fun save(event: OutboxEvent)
    fun findPending(limit: Int): List<OutboxEvent>
    fun markPublished(id: UUID, publishedAt: Instant)
    fun scheduleRetry(event: OutboxEvent)
}