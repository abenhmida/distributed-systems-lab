package com.krizaldis.distributedsystem.order.application.mapper

import com.krizaldis.distributedsystem.order.application.dto.OrderDto
import com.krizaldis.distributedsystem.order.domain.model.Order

object OrderMapper {
    fun toOrder(order: Order): OrderDto = OrderDto(
        id = order.id.toString(),
        customerId = order.customerId,
        status = order.status.name,
        total = order.total().amount,
        currency = order.total().currency
    )
}