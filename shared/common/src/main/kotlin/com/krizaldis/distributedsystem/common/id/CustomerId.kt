package com.krizaldis.distributedsystem.common.id

import java.util.UUID

class CustomerId(override val value: UUID) : AggregateId(value) {
    companion object {
        fun random() =
            CustomerId(UUID.randomUUID())
    }
}