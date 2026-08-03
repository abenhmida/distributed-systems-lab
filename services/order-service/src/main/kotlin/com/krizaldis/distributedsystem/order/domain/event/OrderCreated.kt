package com.krizaldis.distributedsystem.order.domain.event

import com.krizaldis.common.domain.DomainEvent
import com.krizaldis.common.id.EventId
import java.time.Instant

data class OrderCreated(
    override val eventId: EventId,
    override val occurredAt: Instant,
    override val aggregateId: String,
    val customerId: String,
    val totalAmount: String
) : DomainEvent {
    override val version: Int
        get() = 1
    override val eventType: String
        get() = "OrderCreated"
}
