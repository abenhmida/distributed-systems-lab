package com.krizaldis.distributedsystem.order.infrastructure.outbox.mapper

import com.krizaldis.distributedsystem.order.infrastructure.outbox.entity.OutboxEventEntity
import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent

object OutboxEntityMapper {

    fun toEntity(event: OutboxEvent) = OutboxEventEntity(
        id = event.id,
        aggregateType = event.aggregateType,
        aggregateId = event.aggregateId,
        eventType = event.eventType,
        eventVersion = event.eventVersion,
        payload = event.payload,
        headers = event.headers,
        occurredAt = event.occurredAt,
        publishedAt = event.publishedAt,
        retryCount = event.retryCount,
        nextRetryAt = event.nextRetryAt,
        createdAt = event.createdAt,
        updatedAt = event.updatedAt
    )

    fun toDomain(entity: OutboxEvent) = OutboxEvent(
        id = entity.id,
        aggregateType = entity.aggregateType,
        aggregateId = entity.aggregateId,
        eventType = entity.eventType,
        eventVersion = entity.eventVersion,
        payload = entity.payload,
        headers = entity.headers,
        occurredAt = entity.occurredAt,
        publishedAt = entity.publishedAt,
        retryCount = entity.retryCount,
        nextRetryAt = entity.nextRetryAt,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )
}