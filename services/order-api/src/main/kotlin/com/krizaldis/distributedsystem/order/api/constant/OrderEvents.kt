package com.krizaldis.distributedsystem.order.api.constant

import com.krizaldis.distributedsystem.common.event.EventType

object OrderEvents {
    val ORDER_CREATED = EventType("OrderCreated")
    val ORDER_CANCELLED = EventType("OrderCancelled")
    val ORDER_CONFIRMED = EventType("OrderConfirmed")
    val ORDER_REJECTED = EventType("OrderRejected")
}