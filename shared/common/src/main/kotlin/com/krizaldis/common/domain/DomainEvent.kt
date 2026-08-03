package com.krizaldis.common.domain

import com.krizaldis.common.id.EventId
import java.time.Instant

interface DomainEvent {
    val eventId: EventId
    val version: Int
    val occurredAt: Instant
    val eventType: String
    val aggregateId: String
}