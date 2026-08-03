package com.krizaldis.distributedsystem.order.application.command

import java.math.BigDecimal

data class CreateOrderCommand(
    val customerId: String,
    val items: List<Item>
) {
    data class Item(
        val productId: String,
        val quantity: Int,
        val price: BigDecimal,
    )
}
