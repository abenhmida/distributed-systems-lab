package com.krizaldis.distributedsystem.order.domain.model

import com.krizaldis.common.domain.ValueObject
import java.math.BigDecimal
import java.util.Currency

data class Money(
    val amount: BigDecimal,
    val currency: String,
) : ValueObject() {
    init {
        require(amount >= BigDecimal.ZERO) { "Amount must be positive" }
        require(currency.isNotBlank()) { "Currency is required" }
    }

    operator fun plus(other: Money): Money {
        require(currency == other.currency)
        return copy(amount = this.amount + other.amount)
    }

    operator fun times(quantity: Int): Money {
        return copy(amount = amount.multiply(quantity.toBigDecimal()))
    }

    companion object {
        val ZERO = Money(BigDecimal.ZERO, "EUR")
    }
}
