package com.krizaldis.distributedsystem.common.messaging

import java.util.UUID

@JvmInline
value class CausationId(val value: UUID) {
    companion object {
        fun generate(): CausationId = CausationId(UUID.randomUUID())
    }
    override fun toString(): String = value.toString()
}