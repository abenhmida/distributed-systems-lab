package com.krizaldis.distributedsystem.order.application.port.outbound

import com.krizaldis.distributedsystem.common.id.OrderId

fun interface ExistsOrderPort {
    fun exists(id: OrderId): Boolean
}