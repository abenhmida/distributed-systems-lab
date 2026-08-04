package com.krizaldis.distributedsystem.common.event

data class EventEnvelope<T>(
    val metadata: EventMetadata,
    val payload: T
)