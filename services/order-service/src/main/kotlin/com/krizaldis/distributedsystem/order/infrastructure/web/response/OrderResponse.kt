package com.krizaldis.distributedsystem.order.infrastructure.web.response

import java.math.BigDecimal

data class OrderResponse(
    val id: String,
    val customerId: String,
    val status: String,
    val total: BigDecimal,
    val currency: String
)
