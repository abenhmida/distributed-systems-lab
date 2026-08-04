package com.krizaldis.distributedsystem.common.idempotency

import java.util.UUID

interface IdempotencyService {
    fun alreadyProcessed(eventId: UUID, consumer: String): Boolean
    fun markProcessed(eventId: UUID, consumer: String)
}