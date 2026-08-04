package com.krizaldis.distributedsystem.order.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import java.util.UUID
import kotlin.time.Instant

@Entity
@IdClass(ProcessedEventEntityId::class)
@Table(name = "processed_events")
class ProcessedEventEntity (
    @Id
    @Column(name = "event_id")
    val id: UUID,

    @Id
    @Column("consumer_name")
    val consumerName: String,

    @Column("processed_at")
    val processedAt: Instant,
)