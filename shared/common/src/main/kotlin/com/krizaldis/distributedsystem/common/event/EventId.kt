package com.krizaldis.distributedsystem.common.event

import java.util.UUID

data class EventId( val value: UUID) {
    companion object {
        fun random() = EventId(UUID.randomUUID())
    }
}