package com.krizaldis.distributedsystem.common.event

import com.krizaldis.distributedsystem.common.messaging.CausationId
import com.krizaldis.distributedsystem.common.messaging.CorrelationId
import com.krizaldis.distributedsystem.common.messaging.TenantId
import com.krizaldis.distributedsystem.common.messaging.TraceId
import java.time.Instant

data class EventMetadata(
    val eventId: String,
    val aggregateId: String,
    val aggregateType: String,
    val eventType: String,
    val version: EventVersion,
    val occurredAt: Instant,
    val producedAt: Instant = Instant.now(),
    val correlationId: CorrelationId = CorrelationId.generate(),
    val causationId: CausationId = CausationId.generate(),
    val traceId: TraceId? = TraceId("trace-id"),
    val tenantId: TenantId? = null,
    val producer: String? = null,
    val headers: EventHeaders? = EventHeaders()
)