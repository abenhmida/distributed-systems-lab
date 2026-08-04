package com.krizaldis.distributedsystem.common.idempotency

import java.time.Instant
import java.util.UUID

data class ProcessedEvent(
    val eventId: UUID,
    val consumer: String,
    val processedAt: Instant,
)
