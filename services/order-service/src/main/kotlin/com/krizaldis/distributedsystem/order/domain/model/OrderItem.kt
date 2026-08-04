package com.krizaldis.distributedsystem.order.domain.model

import com.krizaldis.distributedsystem.common.domain.ValueObject

data class OrderItem(
    val productId: String,
    val quantity: Int,
    val unitPrice: Money,
) : ValueObject() {
    init {
        require(quantity > 0)
        require(productId.isNotBlank())
    }

    fun total(): Money {
        return unitPrice * quantity
    }
}
