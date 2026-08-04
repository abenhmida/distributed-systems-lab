package com.krizaldis.distributedsystem.common.event.descriptor

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventType
import com.krizaldis.distributedsystem.common.event.EventVersion
import kotlin.reflect.KClass

interface EventDescriptor<T: DomainEvent> {
    /**
     * Stable event name.
     */
    val eventType: EventType

    /**
     * Schema version.
     */
    val version: EventVersion

    /**
     * Payload class.
     */
    val payloadType: KClass<T>
}