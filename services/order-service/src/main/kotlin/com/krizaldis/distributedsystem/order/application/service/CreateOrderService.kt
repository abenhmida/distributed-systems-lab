package com.krizaldis.distributedsystem.order.application.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.krizaldis.common.id.OrderId
import com.krizaldis.common.result.Result
import com.krizaldis.common.result.success
import com.krizaldis.distributedsystem.order.application.command.CreateOrderCommand
import com.krizaldis.distributedsystem.order.application.dto.OrderDto
import com.krizaldis.distributedsystem.order.application.mapper.OrderMapper
import com.krizaldis.distributedsystem.order.application.port.inbound.CreateOrderUseCase
import com.krizaldis.distributedsystem.order.application.port.outbound.SaveOrderPort
import com.krizaldis.distributedsystem.order.domain.model.Money
import com.krizaldis.distributedsystem.order.domain.model.Order
import com.krizaldis.distributedsystem.order.domain.model.OrderItem
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreateOrderService(
    private val saveOrderPort: SaveOrderPort,
    private val mapper: OrderMapper,
) : CreateOrderUseCase {
    override fun create(command: CreateOrderCommand): Result<OrderDto> {
        val order = Order.create(
            id = OrderId.random(),
            customerId = command.customerId,
            items = command.items.map {
                OrderItem(
                    productId = it.productId,
                    quantity = it.quantity,
                    unitPrice = Money(
                        amount = it.price,
                        currency = "EUR"
                    )
                )
            }
        )
        val savedOrder = saveOrderPort.save(order)
        
        return success(
            mapper.toOrder(savedOrder)
        )
    }
}