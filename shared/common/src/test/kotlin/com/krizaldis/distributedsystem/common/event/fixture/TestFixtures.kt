package com.krizaldis.distributedsystem.common.event.fixture// TestFixtures.kt - place in src/test/kotlin/your/package/

import com.krizaldis.distributedsystem.common.domain.DomainEvent
import com.krizaldis.distributedsystem.common.event.CausationId
import com.krizaldis.distributedsystem.common.event.CorrelationId
import com.krizaldis.distributedsystem.common.event.EventEnvelope
import com.krizaldis.distributedsystem.common.event.EventHeaders
import com.krizaldis.distributedsystem.common.event.EventMetadata
import com.krizaldis.distributedsystem.common.event.EventVersion
import com.krizaldis.distributedsystem.common.event.TenantId
import com.krizaldis.distributedsystem.common.event.TraceId
import com.krizaldis.distributedsystem.common.id.EventId
import java.time.Instant
import java.util.UUID

object TestFixtures {

    fun anEventVersion(major: Int = 1) = EventVersion(major)

    fun anEventId(id: UUID = UUID.randomUUID()) = EventId(id)

    fun aCorrelationId(id: UUID = UUID.randomUUID()) = CorrelationId(id)

    fun aCausationId(id: UUID = UUID.randomUUID()) = CausationId(id)

    fun aTraceId(id: String = UUID.randomUUID().toString()) = TraceId(id)

    fun aTenantId(id: String = "tenant-123") = TenantId(id)

    fun anAggregateId(id: String = UUID.randomUUID().toString()) = id

    fun now(): Instant = Instant.now()

    fun anEventMetadata(
        eventId: String = UUID.randomUUID().toString(),
        aggregateId: String = UUID.randomUUID().toString(),
        aggregateType: String = "Order",
        eventType: String = "OrderCreated",
        version: EventVersion = anEventVersion(),
        occurredAt: Instant = now(),
        producedAt: Instant = now(),
        correlationId: CorrelationId = aCorrelationId(),
        causationId: CausationId? = null,
        traceId: TraceId? = null,
        tenantId: TenantId? = null,
        producer: String = "test-producer",
        headers: EventHeaders = EventHeaders()
    ) = EventMetadata(
        eventId = eventId,
        aggregateId = aggregateId,
        aggregateType = aggregateType,
        eventType = eventType,
        version = version,
        occurredAt = occurredAt,
        producedAt = producedAt,
        correlationId = correlationId,
        causationId = causationId,
        traceId = traceId,
        tenantId = tenantId,
        producer = producer,
        headers = headers
    )

    fun aTestDomainEvent(
        eventId: EventId = anEventId(),
        aggregateId: String = anAggregateId(),
        occurredAt: Instant = now(),
        name: String = "TestEvent"
    ) = TestDomainEvent(
        eventId = eventId,
        aggregateId = aggregateId,
        occurredAt = occurredAt
    ).apply {
        // If name is mutable or can be set via copy
    }

    fun <T : DomainEvent> anEventEnvelope(
        metadata: EventMetadata = anEventMetadata(),
        payload: T
    ) = EventEnvelope(
        metadata = metadata,
        payload = payload
    )

    fun anEventEnvelopeWithTestEvent(
        metadata: EventMetadata = anEventMetadata(
            eventType = "TestEvent",
            aggregateType = "Test"
        ),
        event: TestDomainEvent = aTestDomainEvent()
    ) = EventEnvelope(
        metadata = metadata,
        payload = event
    )

    fun orderCreatedEnvelope() = anEventEnvelope(
        metadata = anEventMetadata(
            aggregateType = "Order",
            eventType = "OrderCreated",
            version = anEventVersion(1)
        ),
        payload = aTestDomainEvent(
            aggregateId = "order-123",
            name = "OrderCreated"
        )
    )

    fun paymentProcessedEnvelope() = anEventEnvelope(
        metadata = anEventMetadata(
            aggregateType = "Payment",
            eventType = "PaymentProcessed",
            version = anEventVersion(1)
        ),
        payload = aTestDomainEvent(
            aggregateId = "payment-456",
            name = "PaymentProcessed"
        )
    )

    fun envelopeWithCorrelation() = anEventEnvelope(
        metadata = anEventMetadata(
            correlationId = aCorrelationId(UUID.randomUUID()),
            causationId = aCausationId(UUID.randomUUID())
        ),
        payload = aTestDomainEvent()
    )

    fun envelopeWithTenant() = anEventEnvelope(
        metadata = anEventMetadata(
            tenantId = aTenantId("tenant-999")
        ),
        payload = aTestDomainEvent()
    )
}