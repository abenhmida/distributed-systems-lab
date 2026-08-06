package com.krizaldis.distributedsystem.order.infrastructure.outbox.repository

import com.krizaldis.distributedsystem.common.idempotency.ProcessedEvent
import com.krizaldis.distributedsystem.common.idempotency.ProcessedEventRepository
import com.krizaldis.distributedsystem.order.infrastructure.persistence.entity.ProcessedEventEntity
import com.krizaldis.distributedsystem.order.infrastructure.persistence.entity.ProcessedEventEntityId
import com.krizaldis.distributedsystem.order.infrastructure.persistence.repository.SpringDataProcessedEventRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class JpaEventProcessedRepositoryAdapter(
    private val repository: SpringDataProcessedEventRepository
) : ProcessedEventRepository {
    override fun exists(eventId: UUID, consumer: String): Boolean {
        return repository.findByIdOrNull(ProcessedEventEntityId(eventId, consumer)) != null
    }

    override fun save(processedEvent: ProcessedEvent) {
        repository.save(
            ProcessedEventEntity.from(processedEvent)
        )
    }
}
