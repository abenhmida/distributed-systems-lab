package com.krizaldis.distributedsystem.order.domain.event.v2

import com.krizaldis.distributedsystem.common.event.EventType
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.common.event.descriptor.AbstractEventDescriptor
import com.krizaldis.distributedsystem.order.domain.event.v1.OrderCreated
import org.springframework.stereotype.Component

@Component
object OrderCreatedV2Descriptor : AbstractEventDescriptor<OrderCreated>(
    eventType = EventType("OrderCreated"),
    version = EventVersion(2),
    payloadType = OrderCreated::class
)