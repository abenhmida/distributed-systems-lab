package com.krizaldis.distributedsystem.common.event

import java.util.UUID

@JvmInline
value class CausationId(val value: UUID) {
    override fun toString(): String = value.toString()
}