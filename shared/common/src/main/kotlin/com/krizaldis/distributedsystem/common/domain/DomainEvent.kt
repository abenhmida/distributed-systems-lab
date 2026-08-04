package com.krizaldis.distributedsystem.common.domain

import com.krizaldis.distributedsystem.common.id.EventId
import java.time.Instant

/**
 * Marker interface implemented by every immutable domain event.
 *
 * Domain events represent facts that have already happened.
 * They are framework-independent and contain no serialization concerns.
 */
interface DomainEvent {
    /**
     * Unique identifier for this event instance.
     */
    val eventId: EventId

    /**
     * Schema version.
     */
    val version: Int

    /**
     * Event creation timestamp in UTC.
     */
    val occurredAt: Instant

    /**
     * Logical event name.
     *
     * Example:
     *
     * OrderCreated
     * InventoryReserved
     */
    val eventType: String

    /**
     * Aggregate identifier that produced the event.
     */
    val aggregateId: String
}