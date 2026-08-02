package com.krizaldis.common.domain

import java.time.Instant
import java.util.UUID

data class EventMetadata(
    val eventId: UUID,
    val eventType: String,
    val version: Int,
    val occurredAt: Instant,
    val aggregateId: String,
    val correlationId: UUID,
    val causationId: UUID?,
)