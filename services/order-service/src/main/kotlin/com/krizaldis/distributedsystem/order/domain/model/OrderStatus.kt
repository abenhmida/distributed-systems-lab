package com.krizaldis.distributedsystem.order.domain.model

enum class OrderStatus {
    CREATED,
    CONFIRMED,
    PAID,
    SHIPPED,
    CANCELLED
}