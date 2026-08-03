package com.krizaldis.common.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EventMetadataTest {

    @Test
    fun `should create event metadata`(): Unit {
        val metadata = EventFactory.metadata(
            eventType = "OrderCreated",
            aggregateType = "Order",
            version = 1,
            aggregateId = "123",
        )

        assertThat(metadata.eventType).isEqualTo("OrderCreated")
        assertThat(metadata.version).isEqualTo(1)
    }
}