package com.krizaldis.distributedsystem.common.serialization

import com.krizaldis.distributedsystem.common.event.fixture.TestDomainEvent
import com.krizaldis.distributedsystem.common.event.fixture.TestFixtures
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SerializationTest {

    @Test
    fun `should serialize and deserialize envelope`() {
        val serializer = JacksonEventSerializer(
            ObjectMapperFactory.create()
        )

        val deserializer = JacksonEventDeserializer(
            ObjectMapperFactory.create()
        )

        val envelope = TestFixtures.anEventEnvelopeWithTestEvent()

        val bytes =
            serializer.serialize(envelope)

        val restored =
            deserializer.deserialize(
                bytes,
                TestDomainEvent::class.java
            )

        assertThat(restored)
            .isEqualTo(envelope)
    }
}