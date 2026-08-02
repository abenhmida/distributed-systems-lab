package com.krizaldis.common.id

import java.util.UUID

open class OrderId(override val value: UUID) : AggregateId(value) {
    companion object {
        fun random(): OrderId = OrderId(UUID.randomUUID())
    }
}