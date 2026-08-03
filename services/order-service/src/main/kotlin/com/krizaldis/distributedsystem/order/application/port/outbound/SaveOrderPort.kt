package com.krizaldis.distributedsystem.order.application.port.outbound

import com.krizaldis.distributedsystem.order.domain.model.Order

fun interface SaveOrderPort {
    fun save(order: Order): Order
}