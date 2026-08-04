package com.krizaldis.distributedsystem.common.event.registry

import com.krizaldis.distributedsystem.common.event.EventType
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.common.event.descriptor.EventDescriptor
import java.util.concurrent.ConcurrentHashMap

class DefaultEventRegistry : EventRegistry {
    private val descriptors = ConcurrentHashMap<EventKey, EventDescriptor<*>>()

    override fun register(descriptor: EventDescriptor<*>) {
        val key = EventKey(descriptor.eventType, descriptor.version)
        if (descriptors.putIfAbsent(key, descriptor) != null) {
            throw DuplicateEventDescriptorException(
                descriptor.eventType.value,
                descriptor.version.value
            )
        }
    }

    override fun descriptor(
        eventType: String,
        version: Int
    ): EventDescriptor<*> {
        return descriptors[EventKey(EventType(eventType), EventVersion(version))]
            ?: throw UnknownEventException(eventType, version)
    }

    override fun descriptors(): Collection<EventDescriptor<*>> = descriptors.values
}