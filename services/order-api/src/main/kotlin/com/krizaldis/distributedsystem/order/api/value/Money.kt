package com.krizaldis.distributedsystem.order.api.value

import java.math.BigDecimal

data class Money(val amount: BigDecimal, val currency: Currency) {
    init {
        require(amount >= BigDecimal.ZERO) { "Amount must be positive" }
    }

    operator fun plus(other: Money): Money {
        require(currency == other.currency)
        return copy(amount = this.amount + other.amount)
    }

    operator fun times(quantity: Int): Money {
        return copy(amount = amount.multiply(quantity.toBigDecimal()))
    }

    companion object {
        val ZERO = Money(BigDecimal.ZERO, Currency.EUR)
    }
}