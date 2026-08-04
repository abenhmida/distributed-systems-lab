package com.krizaldis.distributedsystem.common.event.registry

class UnknownEventException(eventType: String, version: Int) : RuntimeException(
    "Unknown event type: $eventType, version: $version"
)