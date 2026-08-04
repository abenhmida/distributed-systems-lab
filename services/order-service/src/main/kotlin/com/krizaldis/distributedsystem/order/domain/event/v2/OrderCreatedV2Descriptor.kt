package com.krizaldis.distributedsystem.order.domain.event.v2

import com.krizaldis.distributedsystem.common.event.EventDescriptor
import com.krizaldis.distributedsystem.common.event.EventTypes
import kotlin.reflect.KClass

object OrderCreatedV2Descriptor : EventDescriptor<OrderCreated> {
    override val eventType: String
        get() = EventTypes.ORDER_CREATED
    override val version: Int
        get() = 2
    override val payloadType: KClass<OrderCreated>
        get() = OrderCreated::class
}