package com.krizaldis.distributedsystem.common.event.descriptor

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventVersion
import kotlin.reflect.KClass

interface EventDescriptor<T: DomainEvent> {
    /**
     * Stable event name.
     */
    val eventType: String

    /**
     * Schema version.
     */
    val version: EventVersion

    /**
     * Payload class.
     */
    val payloadType: KClass<T>
}