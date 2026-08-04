package com.krizaldis.distributedsystem.common.event.registry

class DuplicateEventDescriptorException(eventType: String, version: Int) : RuntimeException(
    "Descriptor already registered for [$eventType] version [$version]"
)