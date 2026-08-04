package com.krizaldis.distributedsystem.common.serialization

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventEnvelope

interface EventSerializer {
    val format: SerializationFormat

    fun <T : DomainEvent> serialize(envelope: EventEnvelope<T>): ByteArray
}