package com.krizaldis.distributedsystem.order.api.value

data class OrderItem(
    val productId: ProductId,
    val quantity: Int,
    val unitPrice: Money
) {

    init {
        require(quantity > 0)
    }
}