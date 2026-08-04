package com.krizaldis.distributedsystem.order.application.port.inbound

import com.krizaldis.distributedsystem.common.id.OrderId
import com.krizaldis.distributedsystem.common.result.Result
import com.krizaldis.distributedsystem.order.application.dto.OrderDto

fun interface GetOrderUseCase {
    fun get(orderId: OrderId): Result<OrderDto>
}
