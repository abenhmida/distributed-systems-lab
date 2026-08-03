package com.krizaldis.distributedsystem.order.application.port.outbound

import com.krizaldis.common.id.OrderId

fun interface ExistsOrderPort {
    fun exists(id: OrderId): Boolean
}