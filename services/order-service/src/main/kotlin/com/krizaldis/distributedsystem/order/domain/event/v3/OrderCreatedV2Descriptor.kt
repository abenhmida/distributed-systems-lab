package com.krizaldis.distributedsystem.order.domain.event.v3

import com.krizaldis.distributedsystem.common.event.EventTypes
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.common.event.descriptor.AbstractEventDescriptor
import com.krizaldis.distributedsystem.order.domain.event.v1.OrderCreated
import org.springframework.stereotype.Component

@Component
object OrderCreatedV3Descriptor : AbstractEventDescriptor<OrderCreated>(
    eventType = EventTypes.ORDER_CREATED,
    version = EventVersion(3),
    payloadType = OrderCreated::class
)