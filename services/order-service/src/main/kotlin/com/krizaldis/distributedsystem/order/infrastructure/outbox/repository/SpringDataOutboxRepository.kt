package com.krizaldis.distributedsystem.order.infrastructure.outbox.repository

import com.krizaldis.distributedsystem.order.infrastructure.outbox.entity.OutboxEventEntity
import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.NativeQuery
import java.util.UUID

interface SpringDataOutboxRepository : JpaRepository<OutboxEventEntity, UUID> {

    @NativeQuery(
        """
        SELECT *
            FROM outbox_events
        WHERE published_at IS NULL AND (next_retry_at IS NULL OR next_retry_at <= NOW())
        ORDER BY occurred_at
        LIMIT :limit
        FOR UPDATE SKIP LOCKED;
        """
    )
    fun findPending(pageable: Pageable): List<OutboxEvent>
}