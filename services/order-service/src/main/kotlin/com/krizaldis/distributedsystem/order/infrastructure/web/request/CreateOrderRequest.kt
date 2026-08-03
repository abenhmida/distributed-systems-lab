package com.krizaldis.distributedsystem.order.infrastructure.web.request

import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal

data class CreateOrderRequest(
    @field:NotBlank
    val customerId: String,

    @field:NotEmpty
    @field:Valid
    val items: List<OrderItemRequest>
)

data class OrderItemRequest(
    @field:NotBlank
    val productId: String,

    @field:Min(1)
    val quantity: Int,

    @field:DecimalMin("0.01")
    val price: BigDecimal,
)
