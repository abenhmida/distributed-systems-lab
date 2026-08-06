package com.krizaldis.distributedsystem.common.event

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.messaging.CausationId
import com.krizaldis.distributedsystem.common.messaging.CorrelationId
import com.krizaldis.distributedsystem.common.messaging.TenantId
import com.krizaldis.distributedsystem.common.messaging.TraceId

class EventEnvelopeFactory(
    private val metadataBuilder: EventMetadataBuilder
) {
    fun <T : DomainEvent> create(
        event: T,
        aggregateType: String,
        producer: String,
        correlationId: CorrelationId,
        causationId: CausationId? = null,
        traceId: TraceId? = null,
        tenantId: TenantId? = null,
        headers: EventHeaders = EventHeaders()
    ): EventEnvelope<T> {
        val metadata = metadataBuilder.build(
            event = event,
            aggregateType = aggregateType,
            producer = producer,
            correlationId = correlationId,
            causationId = causationId,
            traceId = traceId,
            tenantId = tenantId,
            headers = headers
        )

        return EventEnvelope(metadata = metadata, payload = event)

    }
}