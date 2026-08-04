package com.krizaldis.distributedsystem.order.application.service

import com.krizaldis.distributedsystem.common.id.OrderId
import com.krizaldis.distributedsystem.common.result.Result
import com.krizaldis.distributedsystem.common.result.success
import com.krizaldis.distributedsystem.order.application.command.CreateOrderCommand
import com.krizaldis.distributedsystem.order.application.dto.OrderDto
import com.krizaldis.distributedsystem.order.application.mapper.OrderMapper
import com.krizaldis.distributedsystem.order.application.port.inbound.CreateOrderUseCase
import com.krizaldis.distributedsystem.order.application.port.outbound.SaveOrderPort
import com.krizaldis.distributedsystem.order.domain.model.Money
import com.krizaldis.distributedsystem.order.domain.model.Order
import com.krizaldis.distributedsystem.order.domain.model.OrderItem
import com.krizaldis.distributedsystem.order.infrastructure.outbox.OutboxRepository
import com.krizaldis.distributedsystem.order.infrastructure.outbox.factory.OutboxEventFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreateOrderService(
    private val saveOrderPort: SaveOrderPort,
    private val outboxRepository: OutboxRepository,
    private val outboxFactory: OutboxEventFactory
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

        order.domainEvents()
            .map {
                outboxFactory.from(
                    aggregateType = "Order",
                    event = it
                )
            }
            .forEach(outboxRepository::save)

        order.clearDomainEvents()

        return success(
            OrderMapper.toOrder(savedOrder)
        )
    }
}