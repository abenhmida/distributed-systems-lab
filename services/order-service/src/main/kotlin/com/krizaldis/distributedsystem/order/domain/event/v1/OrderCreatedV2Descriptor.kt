package com.krizaldis.distributedsystem.order.domain.event.v1

import com.krizaldis.distributedsystem.common.event.EventDescriptor
import com.krizaldis.distributedsystem.common.event.EventTypes
import kotlin.reflect.KClass

object OrderCreatedV1Descriptor : EventDescriptor<OrderCreated> {
    override val eventType: String
        get() = EventTypes.ORDER_CREATED
    override val version: Int
        get() = 1
    override val payloadType: KClass<OrderCreated>
        get() = OrderCreated::class
}