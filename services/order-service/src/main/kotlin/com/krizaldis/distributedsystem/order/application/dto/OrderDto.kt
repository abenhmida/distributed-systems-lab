package com.krizaldis.distributedsystem.order.application.dto

import java.math.BigDecimal

data class OrderDto(
    val id: String,
    val customerId: String,
    val status: String,
    val total: BigDecimal,
    val currency: String
)