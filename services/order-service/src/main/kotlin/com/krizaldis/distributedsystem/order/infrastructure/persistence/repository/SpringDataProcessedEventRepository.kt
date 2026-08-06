package com.krizaldis.distributedsystem.order.infrastructure.persistence.repository

import com.krizaldis.distributedsystem.order.infrastructure.persistence.entity.ProcessedEventEntity
import com.krizaldis.distributedsystem.order.infrastructure.persistence.entity.ProcessedEventEntityId
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringDataProcessedEventRepository: JpaRepository<ProcessedEventEntity, ProcessedEventEntityId> {
}