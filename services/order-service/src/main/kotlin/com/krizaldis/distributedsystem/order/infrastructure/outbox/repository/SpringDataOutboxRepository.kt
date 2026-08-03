package com.krizaldis.distributedsystem.order.infrastructure.outbox.repository

import com.krizaldis.distributedsystem.order.infrastructure.outbox.entity.OutboxEventEntity
import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface SpringDataOutboxRepository : JpaRepository<OutboxEventEntity, UUID> {

    @Query(
        """
        select e
        from OutboxEventEntity e
        where e.publishedAt is null
        and (
            e.nextRetryAt is null
            or e.nextRetryAt <= CURRENT_TIMESTAMP
        )
        order by e.occurredAt
        """
    )
    fun findPending(pageable: Pageable): List<OutboxEvent>
}