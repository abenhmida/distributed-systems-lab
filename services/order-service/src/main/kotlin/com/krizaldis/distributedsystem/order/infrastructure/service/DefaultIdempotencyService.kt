package com.krizaldis.distributedsystem.order.infrastructure.service

import com.krizaldis.distributedsystem.common.idempotency.IdempotencyService
import com.krizaldis.distributedsystem.common.idempotency.ProcessedEvent
import com.krizaldis.distributedsystem.common.idempotency.ProcessedEventRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class DefaultIdempotencyService(
    private val repository: ProcessedEventRepository,
) : IdempotencyService {
    override fun alreadyProcessed(eventId: UUID, consumer: String): Boolean =
        repository.exists(eventId, consumer)

    override fun markProcessed(eventId: UUID, consumer: String) {
        repository.save(ProcessedEvent(eventId, consumer, Instant.now()))
    }
}