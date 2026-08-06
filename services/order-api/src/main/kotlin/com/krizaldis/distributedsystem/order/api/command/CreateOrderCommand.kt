package com.krizaldis.distributedsystem.order.api.command

import com.krizaldis.distributedsystem.common.command.CommandMetadata
import com.krizaldis.distributedsystem.order.api.value.*

data class CreateOrderCommand(
    val orderId: OrderId,
    val customerId: CustomerId,
    val items: List<OrderItem>,
    val metadata: CommandMetadata
) {
    init {
        require(items.isNotEmpty()) {
            "An order must contain at least one item."
        }

        require(items.distinctBy { it.productId }.size == items.size) {
            "Duplicate products are not allowed."
        }
    }
}