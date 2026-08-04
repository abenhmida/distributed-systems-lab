package com.krizaldis.distributedsystem.common.event.registry

import com.krizaldis.distributedsystem.common.event.EventVersion

data class EventKey(val eventType: String, val version: EventVersion)
