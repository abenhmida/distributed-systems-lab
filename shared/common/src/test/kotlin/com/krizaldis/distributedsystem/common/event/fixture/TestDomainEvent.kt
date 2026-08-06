package com.krizaldis.distributedsystem.common.event.fixture

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventId
import com.krizaldis.distributedsystem.common.event.EventType
import java.time.Instant

data class TestDomainEvent(
    override val eventId: EventId,
    override val aggregateId: String,
    override val occurredAt: Instant
) : DomainEvent {
    override val eventType = EventType("TestEvent")
    override val version = 1
    val name = "Me"
}