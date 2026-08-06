package com.krizaldis.distributedsystem.order.application.port.outbound

import com.krizaldis.distributedsystem.order.api.value.OrderId

fun interface ExistsOrderPort {
    fun exists(id: OrderId): Boolean
}