package com.krizaldis.distributedsystem.common.domain

import com.krizaldis.distributedsystem.common.event.CorrelationId
import com.krizaldis.distributedsystem.common.event.EventHeaders
import com.krizaldis.distributedsystem.common.event.EventMetadata
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.common.event.TenantId
import com.krizaldis.distributedsystem.common.event.TraceId
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
            causationId = null,
            aggregateType = aggregateType,
            producedAt = producedAt,
            traceId = traceId,
            tenantId = tenantId,
            producer = producer!!,
            headers = headers,
        )
    }
}