package com.krizaldis.distributedsystem.order.api.value

import java.util.UUID

@JvmInline
value class OrderId(val value: UUID) {
    companion object {
        fun generate() =
            OrderId(UUID.randomUUID())
    }

    override fun toString() =
        value.toString()
}