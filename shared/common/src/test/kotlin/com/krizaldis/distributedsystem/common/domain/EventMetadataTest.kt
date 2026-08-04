package com.krizaldis.distributedsystem.common.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EventMetadataTest {

    @Test
    fun `should create event metadata`() {
        val metadata = EventFactory.metadata(
            eventType = "OrderCreated",
            version = 1,
            aggregateId = "123",
            aggregateType = "Order",
        )

        assertThat(metadata.eventType).isEqualTo("OrderCreated")
        assertThat(metadata.version).isEqualTo(1)
    }
}