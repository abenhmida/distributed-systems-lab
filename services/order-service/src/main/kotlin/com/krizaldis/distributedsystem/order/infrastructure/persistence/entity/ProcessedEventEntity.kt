package com.krizaldis.distributedsystem.order.infrastructure.persistence.entity

import com.krizaldis.distributedsystem.common.idempotency.ProcessedEvent
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@IdClass(ProcessedEventEntityId::class)
@Table(name = "processed_events")
class ProcessedEventEntity (
    @Id
    @Column(name = "event_id")
    val id: UUID,

    @Id
    @Column(name = "consumer_name")
    val consumerName: String,

    @Column(name = "processed_at")
    val processedAt: Instant,
) {
    companion object {
        fun from(processedEvent: ProcessedEvent): ProcessedEventEntity {
            return ProcessedEventEntity(
                id = processedEvent.eventId,
                consumerName = processedEvent.consumer,
                processedAt = processedEvent.processedAt
            )
        }
    }
}