package com.krizaldis.distributedsystem.order.domain.event

import com.krizaldis.distributedsystem.common.event.EventDescriptor

interface EventRegistry {
    fun descriptor(eventType: String, version: Int): EventDescriptor<*>
}