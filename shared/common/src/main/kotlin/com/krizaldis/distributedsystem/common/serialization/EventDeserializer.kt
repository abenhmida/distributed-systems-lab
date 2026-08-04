package com.krizaldis.distributedsystem.common.serialization

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventEnvelope

interface EventDeserializer {
    fun <T : DomainEvent> deserialize(bytes: ByteArray, eventClass: Class<T>): EventEnvelope<T>
}