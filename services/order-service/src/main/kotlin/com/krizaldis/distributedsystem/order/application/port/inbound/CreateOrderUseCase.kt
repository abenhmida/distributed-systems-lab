package com.krizaldis.distributedsystem.order.application.port.inbound

import com.krizaldis.common.result.Result
import com.krizaldis.distributedsystem.order.application.command.CreateOrderCommand
import com.krizaldis.distributedsystem.order.application.dto.OrderDto

fun interface CreateOrderUseCase {
    fun create(
        command: CreateOrderCommand
    ): Result<OrderDto>
}