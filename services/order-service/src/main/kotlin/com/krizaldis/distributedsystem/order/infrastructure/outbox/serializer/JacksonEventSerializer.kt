package com.krizaldis.distributedsystem.order.infrastructure.outbox.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class JacksonEventSerializer(
    private val objectMapper: ObjectMapper
) : EventSerializer {
    override fun serialize(order: Any): String =
        objectMapper.writeValueAsString(order)
}