package com.krizaldis.distributedsystem.order.infrastructure.outbox.metrics

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class OutboxMetrics(registry: MeterRegistry) {
    val published = registry.counter("outbox.published")
    val failed = registry.counter("outbox.failed")
}