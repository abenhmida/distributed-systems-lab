package com.krizaldis.distributedsystem.common.event

import com.krizaldis.distributedsystem.common.domain.DomainEvent

data class EventEnvelope<T: DomainEvent>(
    val metadata: EventMetadata,
    val payload: T
)