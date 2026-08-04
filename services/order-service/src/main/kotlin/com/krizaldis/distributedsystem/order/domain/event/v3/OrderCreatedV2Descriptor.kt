package com.krizaldis.distributedsystem.order.domain.event.v3

import com.krizaldis.distributedsystem.common.event.EventDescriptor
import com.krizaldis.distributedsystem.common.event.EventTypes
import kotlin.reflect.KClass

object OrderCreatedV3Descriptor : EventDescriptor<OrderCreated> {
    override val eventType: String
        get() = EventTypes.ORDER_CREATED
    override val version: Int
        get() = 3
    override val payloadType: KClass<OrderCreated>
        get() = OrderCreated::class
}