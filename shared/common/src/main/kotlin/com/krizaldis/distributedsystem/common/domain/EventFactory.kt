package com.krizaldis.distributedsystem.common.domain

import com.krizaldis.distributedsystem.common.messaging.CorrelationId
import com.krizaldis.distributedsystem.common.event.EventHeaders
import com.krizaldis.distributedsystem.common.event.EventMetadata
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.common.messaging.CausationId
import com.krizaldis.distributedsystem.common.messaging.TenantId
import com.krizaldis.distributedsystem.common.messaging.TraceId
import java.time.Clock
import java.time.Instant
import java.util.UUID

object EventFactory {
    fun metadata(
        eventType: String,
        version: Int,
        aggregateId: String,
        clock: Clock = Clock.systemUTC(),
        aggregateType: String,
        correlationId: UUID = UUID.randomUUID(),
        producedAt: Instant = Instant.now(clock),
        causationId: UUID = UUID.randomUUID(),
        traceId: TraceId? = null,
        tenantId: TenantId? = null,
        producer: String? = null,
        headers: EventHeaders = EventHeaders(),
    ): EventMetadata {
        return EventMetadata(
            eventId = UUID.randomUUID().toString(),
            eventType = eventType,
            version = EventVersion(version),
            aggregateId = aggregateId,
            occurredAt = clock.instant(),
            correlationId = CorrelationId(correlationId),
            causationId = CausationId(causationId),
            aggregateType = aggregateType,
            producedAt = producedAt,
            traceId = traceId,
            tenantId = tenantId,
            producer = producer ?: "unknown",
            headers = headers,
        )
    }
}