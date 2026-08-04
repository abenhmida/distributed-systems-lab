package com.krizaldis.distributedsystem.order.api.registry

import com.krizaldis.distributedsystem.order.api.descriptor.OrderCancelledV1Descriptor
import com.krizaldis.distributedsystem.order.api.descriptor.OrderConfirmedV1Descriptor
import com.krizaldis.distributedsystem.order.api.descriptor.OrderCreatedV1Descriptor
import com.krizaldis.distributedsystem.order.api.descriptor.OrderCreatedV2Descriptor
import com.krizaldis.distributedsystem.order.api.descriptor.OrderCreatedV3Descriptor
import com.krizaldis.distributedsystem.order.api.descriptor.OrderRejectedV1Descriptor

object OrderRegistry {
    val descriptors = listOf(
        OrderCreatedV1Descriptor,
        OrderCreatedV3Descriptor,
        OrderCreatedV2Descriptor,
        OrderCancelledV1Descriptor,
        OrderConfirmedV1Descriptor,
        OrderRejectedV1Descriptor
    )
}