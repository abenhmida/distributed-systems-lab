package com.krizaldis.distributedsystem.order.infrastructure.web.mapper

import com.krizaldis.distributedsystem.order.application.command.CreateOrderCommand
import com.krizaldis.distributedsystem.order.application.dto.OrderDto
import com.krizaldis.distributedsystem.order.infrastructure.web.request.CreateOrderRequest
import com.krizaldis.distributedsystem.order.infrastructure.web.response.OrderResponse
import org.springframework.stereotype.Component

@Component
object OrderWebMapper {

    fun toCommand(request: CreateOrderRequest): CreateOrderCommand = CreateOrderCommand(
        customerId = request.customerId,
        items = request.items.map {
            CreateOrderCommand.Item(
                productId = it.productId,
                quantity = it.quantity,
                price = it.price
            )
        }
    )

    fun toResponse(dto: OrderDto) = OrderResponse(
        id = dto.id,
        customerId = dto.customerId,
        status = dto.status,
        total = dto.total,
        currency = dto.currency
    )
}