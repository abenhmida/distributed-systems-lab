package com.krizaldis.distributedsystem.order.infrastructure.outbox.factory

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventEnvelope
import com.krizaldis.distributedsystem.common.event.EventMetadata
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent
import com.krizaldis.distributedsystem.order.infrastructure.outbox.serializer.EventSerializer
import org.springframework.stereotype.Component

@Component
class DefaultOutboxEventFactory(
    private val serializer: EventSerializer
) : OutboxEventFactory {

    override fun from(aggregateType: String, event: DomainEvent): OutboxEvent {

        val envelope = EventEnvelope(
            metadata = EventMetadata(
                eventId = event.eventId.toString(),
                aggregateId = event.aggregateId,
                aggregateType = aggregateType,
                eventType = event.eventType.value,
                version = EventVersion(event.version),
                occurredAt = event.occurredAt,
            ),
            payload = event
        )

        return OutboxEvent(
            id = event.eventId.value,
            aggregateType = aggregateType,
            aggregateId = event.aggregateId,
            eventType = event.eventType.value,
            eventVersion = event.version,
            payload = serializer.serialize(envelope),
            occurredAt = event.occurredAt
        )

    }

}