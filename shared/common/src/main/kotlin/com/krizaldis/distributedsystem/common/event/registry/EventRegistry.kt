package com.krizaldis.distributedsystem.common.event.registry

import com.krizaldis.distributedsystem.common.event.descriptor.EventDescriptor

interface EventRegistry {
    fun register(descriptor: EventDescriptor<*>)
    fun descriptor(eventType: String, version: Int): EventDescriptor<*>
    fun descriptors(): Collection<EventDescriptor<*>>
}