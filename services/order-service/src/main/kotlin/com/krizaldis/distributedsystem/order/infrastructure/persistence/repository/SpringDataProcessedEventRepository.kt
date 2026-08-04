package com.krizaldis.distributedsystem.order.infrastructure.persistence.repository

import com.krizaldis.distributedsystem.common.idempotency.ProcessedEvent
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringDataProcessedEventRepository: JpaRepository<ProcessedEvent, UUID> {
}