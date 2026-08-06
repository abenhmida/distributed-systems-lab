package com.krizaldis.distributedsystem.order.infrastructure.persistence.mapper

import com.krizaldis.distributedsystem.order.api.value.Currency
import com.krizaldis.distributedsystem.order.api.value.Money
import com.krizaldis.distributedsystem.order.api.value.OrderId
import com.krizaldis.distributedsystem.order.domain.model.Order
import com.krizaldis.distributedsystem.order.infrastructure.persistence.entity.OrderEntity
import com.krizaldis.distributedsystem.order.infrastructure.persistence.entity.OrderItemEntity

object OrderEntityMapper {
    fun toEntity(order: Order): OrderEntity = OrderEntity(
        id = order.id.value,
        customerId = order.customerId,
        status = order.status,
        items = order.items()
            .map {
                OrderItemEntity(
                    productId = it.productId,
                    quantity = it.quantity,
                    unitPrice = it.unitPrice.amount,
                    currency = it.unitPrice.currency.toString()
                )
            }.toMutableList()
    )

    fun toDomain(entity: OrderEntity): Order = Order.restore(
        id = OrderId(entity.id),
        customerId = entity.customerId,
        status = entity.status,
        items = entity.items.map {
            OrderItem(
                productId = it.productId,
                quantity = it.quantity,
                unitPrice = Money(
                    it.unitPrice,
                    Currency.valueOf(it.currency)
                )
            )
        },
    )
}