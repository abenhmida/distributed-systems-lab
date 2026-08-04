package com.krizaldis.distributedsystem.common.id

import java.util.UUID

open class AggregateId(override val value: UUID) : TypedId<UUID>(value) {
    companion object {
        fun random(): AggregateId = AggregateId(UUID.randomUUID())
    }
}
