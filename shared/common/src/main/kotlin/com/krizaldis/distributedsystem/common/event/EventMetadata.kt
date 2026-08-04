package com.krizaldis.distributedsystem.common.event

import java.time.Instant

data class EventMetadata(
    val eventId: String,
    val aggregateId: String,
    val aggregateType: String,
    val eventType: String,
    val version: EventVersion,
    val occurredAt: Instant,
    val producedAt: Instant,
    val correlationId: CorrelationId,
    val causationId: CausationId?,
    val traceId: TraceId?,
    val tenantId: TenantId?,
    val producer: String,
    val headers: EventHeaders = EventHeaders()
)