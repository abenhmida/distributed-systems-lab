package com.krizaldis.distributedsystem.common.event.descriptor

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.EventVersion
import kotlin.reflect.KClass

abstract class AbstractEventDescriptor<T : DomainEvent>(
    override val eventType: String,
    override val version: EventVersion,
    override val payloadType: KClass<T>
) : EventDescriptor<T>