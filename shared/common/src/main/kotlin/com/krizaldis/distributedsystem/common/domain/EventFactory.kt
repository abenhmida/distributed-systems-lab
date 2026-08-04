package com.krizaldis.distributedsystem.common.domain

import com.krizaldis.distributedsystem.common.event.EventMetadata
import java.time.Clock
import java.util.UUID

object EventFactory {
    fun metadata(
        eventType: String,
        version: Int,
        aggregateId: String,
        clock: Clock = Clock.systemUTC(),
        aggregateType: String,
    ): EventMetadata {
        return EventMetadata(
            eventId = UUID.randomUUID().toString(),
            eventType = eventType,
            version = version,
            aggregateId = aggregateId,
            occurredAt = clock.instant(),
            correlationId = UUID.randomUUID().toString(),
            causationId = null,
            aggregateType = aggregateType,
        )
    }
}