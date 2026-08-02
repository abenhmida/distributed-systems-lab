package com.krizaldis.common.domain

data class EventEnvelope<T>(
    val metadata: EventMetadata,
    val payload: T,
)
