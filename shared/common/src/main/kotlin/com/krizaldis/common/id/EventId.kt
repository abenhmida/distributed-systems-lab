package com.krizaldis.common.id

import java.util.UUID

class EventId(override val value: UUID) : TypedId<UUID>(value) {
    companion object {
        fun random() = EventId(UUID.randomUUID())
    }
}