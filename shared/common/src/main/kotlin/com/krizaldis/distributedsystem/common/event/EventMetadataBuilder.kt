package com.krizaldis.distributedsystem.common.event

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import java.time.Clock
import java.time.Instant

class EventMetadataBuilder(
    private val clock: Clock
) {
    fun build(
        event: DomainEvent,
        aggregateType: String,
        producer: String,
        correlationId: CorrelationId,
        causationId: CausationId? = null,
        traceId: TraceId? = null,
        tenantId: TenantId? = null,
        headers: EventHeaders = EventHeaders()
    ): EventMetadata = EventMetadata(
        eventId = event.eventId.toString(),
        aggregateId = event.aggregateId,
        aggregateType = aggregateType,
        eventType = event.eventType.value,
        version = EventVersion(event.version),
        occurredAt = event.occurredAt,
        producedAt = Instant.now(clock),
        correlationId = correlationId,
        causationId = causationId,
        traceId = traceId,
        tenantId = tenantId,
        producer = producer,
        headers = headers
    )
}