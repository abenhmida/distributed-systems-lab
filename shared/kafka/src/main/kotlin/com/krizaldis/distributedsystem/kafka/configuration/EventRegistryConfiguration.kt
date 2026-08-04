package com.krizaldis.distributedsystem.kafka.configuration

import com.krizaldis.distributedsystem.common.event.descriptor.EventDescriptor
import com.krizaldis.distributedsystem.common.event.registry.DefaultEventRegistry
import com.krizaldis.distributedsystem.common.event.registry.EventRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventRegistryConfiguration(
    private val descriptors: List<EventDescriptor<*>>,
) {
    /**
     * each descriptor is a Spring bean, registration is automatic.
     * Adding a new event is as simple as creating a new descriptor
     */
    @Bean
    fun eventRegistry(): EventRegistry {
        val registry = DefaultEventRegistry()
        descriptors.forEach(registry::register)

        return registry
    }
}