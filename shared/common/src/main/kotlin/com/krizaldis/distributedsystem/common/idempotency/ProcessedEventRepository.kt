package com.krizaldis.distributedsystem.common.idempotency

import com.krizaldis.distributedsystem.common.idempotency.ProcessedEvent
import java.util.UUID

interface ProcessedEventRepository {
    fun exists(eventId: UUID, consumer: String): Boolean
    fun save(processedEvent: ProcessedEvent)
}