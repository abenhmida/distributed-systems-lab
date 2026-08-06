package com.krizaldis.distributedsystem.order.domain.model

import com.krizaldis.distributedsystem.common.domain.AggregateRoot
import com.krizaldis.distributedsystem.common.event.EventId
import com.krizaldis.distributedsystem.order.api.value.Money
import com.krizaldis.distributedsystem.order.api.value.OrderId
import com.krizaldis.distributedsystem.order.domain.event.v1.OrderCreated
import com.krizaldis.distributedsystem.order.domain.exception.InvalidOrderStateException
import java.time.Instant

class Order private constructor(
    override val id: OrderId,
    val customerId: String,
    private val items: MutableList<OrderItem>,
    var status: OrderStatus
) : AggregateRoot<OrderId>(id) {

    companion object {
        fun create(id: OrderId, customerId: String, items: List<OrderItem>): Order {
            require(customerId.isNotBlank())
            require(items.isNotEmpty())

            val order = Order(
                id = id,
                customerId = customerId,
                items = items.toMutableList(),
                status = OrderStatus.CREATED
            )

            order.registerEvent(
                OrderCreated(
                    eventId = EventId.random(),
                    occurredAt = Instant.now(),
                    aggregateId = id.toString(),
                    customerId = customerId,
                    totalAmount = order.total()
                        .amount
                        .toPlainString()
                )
            )

            return order
        }

        fun restore(
            id: OrderId,
            customerId: String,
            status: OrderStatus,
            items: List<OrderItem>,
        ): Order {
            return Order(
                id = id,
                customerId = customerId,
                items = items.toMutableList(),
                status = status
            )
        }
    }

    fun items(): List<OrderItem> = items.toList()

    fun total(): Money = items.fold(Money.ZERO) { total, item ->
        total + item.total()
    }

    fun confirm() {
        require(status == OrderStatus.CREATED) {
            throw InvalidOrderStateException("Order cannot be confirmed")
        }
        status = OrderStatus.CONFIRMED
    }

    fun markPaid() {
        require(status == OrderStatus.CONFIRMED)
        status = OrderStatus.PAID
    }

    fun ship() {
        require(status == OrderStatus.PAID)
        status = OrderStatus.SHIPPED
    }

    fun cancel() {
        require(status == OrderStatus.CREATED) {
            throw InvalidOrderStateException("Only newly created orders can be cancelled")
        }
        status = OrderStatus.CANCELLED
    }
}