package com.krizaldis.distributedsystem.common.event.registry

import com.krizaldis.distributedsystem.common.event.EventType
import com.krizaldis.distributedsystem.common.event.EventVersion

data class EventKey(val eventType: EventType, val version: EventVersion)
