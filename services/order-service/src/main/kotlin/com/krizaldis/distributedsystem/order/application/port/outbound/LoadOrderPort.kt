package com.krizaldis.distributedsystem.order.application.port.outbound

import com.krizaldis.distributedsystem.common.id.OrderId
import com.krizaldis.distributedsystem.order.domain.model.Order

fun interface LoadOrderPort {
    fun load(id: OrderId): Order?
}