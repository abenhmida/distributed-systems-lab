package com.krizaldis.distributedsystem.order.domain.repository

import com.krizaldis.distributedsystem.order.api.value.OrderId
import com.krizaldis.distributedsystem.order.domain.model.Order

interface OrderRepository {
    fun save(order: Order): Order
    fun findById(orderId: OrderId): Order?
    fun delete(id: OrderId)
    fun exists(id: OrderId): Boolean
}