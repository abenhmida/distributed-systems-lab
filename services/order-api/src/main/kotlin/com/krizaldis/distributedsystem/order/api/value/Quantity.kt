package com.krizaldis.distributedsystem.order.api.value

@JvmInline
value class Quantity(
    val value: Int
) {
    init {
        require(value > 0) {
            "Quantity must be greater than zero."
        }
    }

    operator fun plus(quantity: Quantity): Quantity {
        return Quantity(value + quantity.value)
    }

    operator fun minus(quantity: Quantity): Quantity {
        return Quantity(value - quantity.value)
    }
}