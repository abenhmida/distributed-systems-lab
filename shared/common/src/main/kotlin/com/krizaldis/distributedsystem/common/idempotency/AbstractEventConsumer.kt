package com.krizaldis.distributedsystem.common.idempotency

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventEnvelope
import java.util.UUID

abstract class AbstractEventConsumer<T : DomainEvent>(
    private val idempotency: IdempotencyService
) {
    abstract val consumerName: String
    fun consume(envelope: EventEnvelope<T>) {
        val id = UUID.fromString(envelope.metadata.eventId)
        if (idempotency.alreadyProcessed(id, consumerName)) {
            return
        }

        process(envelope.payload)
        idempotency.markProcessed(id, consumerName)
    }

    protected abstract fun process(event: T)
}