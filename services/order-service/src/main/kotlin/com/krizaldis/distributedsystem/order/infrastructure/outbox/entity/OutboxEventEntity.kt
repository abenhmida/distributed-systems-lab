package com.krizaldis.distributedsystem.order.infrastructure.outbox.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "outbox_events")
class OutboxEventEntity(
    @Id
    val id: UUID,

    @Column(nullable = false)
    val aggregateType: String,

    @Column(nullable = false)
    val aggregateId: String,

    @Column(nullable = false)
    val eventType: String,

    @Column(nullable = false)
    val eventVersion: Int,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false)
    val payload: String,

    @JdbcTypeCode(SqlTypes.JSON)
    val headers: String?,

    @Column(nullable = false)
    val occurredAt: Instant,

    var publishedAt: Instant?,

    var retryCount: Int,

    var nextRetryAt: Instant?,

    @Column(nullable = false)
    val createdAt: Instant,

    @Column(nullable = false)
    var updatedAt: Instant
)