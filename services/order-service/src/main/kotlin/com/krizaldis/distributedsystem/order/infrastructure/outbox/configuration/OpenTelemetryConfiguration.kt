package com.krizaldis.distributedsystem.order.infrastructure.outbox.configuration

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenTelemetryConfiguration {
    @Bean
    fun meterRegistry(): MeterRegistry = SimpleMeterRegistry()
}