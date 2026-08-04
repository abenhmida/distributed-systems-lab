package com.krizaldis.distributedsystem.order.domain.event.v1

import com.krizaldis.distributedsystem.common.event.EventTypes
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.common.event.descriptor.AbstractEventDescriptor
import org.springframework.stereotype.Component

@Component
object OrderCreatedV1Descriptor : AbstractEventDescriptor<OrderCreated>(
    eventType = EventTypes.ORDER_CREATED,
    version = EventVersion(1),
    payloadType = OrderCreated::class
)