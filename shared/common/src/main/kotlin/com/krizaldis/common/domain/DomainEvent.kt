package com.krizaldis.common.domain

import java.time.Instant
import java.util.UUID

interface DomainEvent {
    val eventId: UUID
    val version: Int
    val occurredAt: Instant
    val eventType: String
    val aggregateId: String
}