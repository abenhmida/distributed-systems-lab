package com.krizaldis.common.domain

import java.time.Clock
import java.util.UUID

object EventFactory {
    fun metadata(
        eventType: String,
        version: Int,
        aggregateId: String,
        clock: Clock = Clock.systemUTC(),
    ): EventMetadata {
        return EventMetadata(
            eventId = UUID.randomUUID(),
            eventType = eventType,
            version = version,
            aggregateId = aggregateId,
            occurredAt = clock.instant(),
            correlationId = UUID.randomUUID(),
            causationId = null
        )
    }
}