package com.krizaldis.distributedsystem.common.serialization

import com.fasterxml.jackson.databind.ObjectMapper
import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventEnvelope

class JacksonEventDeserializer(
    private val mapper: ObjectMapper
) : EventDeserializer {

    override fun <T : DomainEvent> deserialize(
        bytes: ByteArray,
        eventClass: Class<T>
    ): EventEnvelope<T> {
        return try {
            mapper.readValue(
                bytes,
                mapper.typeFactory.constructParametricType(
                    EventEnvelope::class.java,
                    eventClass
                )
            )
        } catch (exception: Exception) {
            throw SerializationException("Unable to deserialize event", exception)
        }
    }
}