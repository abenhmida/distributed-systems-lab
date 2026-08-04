package com.krizaldis.distributedsystem.common.serialization

import com.fasterxml.jackson.databind.ObjectMapper
import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventEnvelope

class JacksonEventSerializer(
    private val mapper: ObjectMapper
) : EventSerializer {
    override val format: SerializationFormat = SerializationFormat.JSON

    override fun <T : DomainEvent> serialize(envelope: EventEnvelope<T>): ByteArray {
        return try {
            mapper.writeValueAsBytes(envelope)
        } catch (exception: Exception) {
            throw SerializationException(
                "Unable to serialize event ${envelope.metadata.eventType}",
                exception
            )
        }
    }
}