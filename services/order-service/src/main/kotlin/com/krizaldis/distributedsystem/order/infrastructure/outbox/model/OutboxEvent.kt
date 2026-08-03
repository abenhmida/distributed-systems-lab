package com.krizaldis.distributedsystem.order.infrastructure.outbox.model

import java.time.Instant
import java.util.UUID

data class OutboxEvent(
    val id: UUID,
    val aggregateType: String,
    val aggregateId: String,
    val eventType: String,
    val eventVersion: Int,
    val payload: String,
    val headers: String? = null,
    val occurredAt: Instant,
    val publishedAt: Instant? = null,
    val retryCount: Int = 0,
    val nextRetryAt: Instant? = null,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now(),
)
