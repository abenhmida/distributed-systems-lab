package com.krizaldis.distributedsystem.common.event

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import kotlin.reflect.KClass

interface EventDescriptor<T: DomainEvent> {
    val eventType: String
    val version: Int
    val payloadType: KClass<T>
}