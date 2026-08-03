package com.krizaldis.distributedsystem.order.domain.event

import com.krizaldis.common.domain.DomainEvent
import java.time.Instant
import java.util.UUID

data class OrderCreated(
    override val eventId: UUID,
    override val occurredAt: Instant,
    override val aggregateId: String
) : DomainEvent {
    override val version: Int
        get() = 1
    override val eventType: String
        get() = "OrderCreated"
}
