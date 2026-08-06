package com.krizaldis.distributedsystem.order.domain.event.v3

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventId
import com.krizaldis.distributedsystem.common.event.EventType
import com.krizaldis.distributedsystem.order.api.constant.OrderEvents
import java.math.BigDecimal
import java.time.Instant

data class OrderCreated(
    override val eventId: EventId,
    override val occurredAt: Instant,
    override val aggregateId: String,
    val customerId: String,
    val totalAmount: String,
    val currency: String,
    val discount: BigDecimal?
) : DomainEvent {
    override val version: Int
        get() = 3
    override val eventType: EventType
        get() = OrderEvents.ORDER_CREATED
}