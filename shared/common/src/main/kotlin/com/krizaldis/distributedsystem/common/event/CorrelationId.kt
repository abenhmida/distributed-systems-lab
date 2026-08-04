package com.krizaldis.distributedsystem.common.event

import java.util.UUID

@JvmInline
value class CorrelationId(val value: UUID) {
    companion object {
        fun generate(): CorrelationId = CorrelationId(UUID.randomUUID())
    }

    override fun toString(): String = value.toString()
}