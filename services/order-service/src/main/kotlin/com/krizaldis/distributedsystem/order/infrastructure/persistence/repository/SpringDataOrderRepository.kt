package com.krizaldis.distributedsystem.order.infrastructure.persistence.repository

import com.krizaldis.distributedsystem.order.infrastructure.persistence.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringDataOrderRepository: JpaRepository<OrderEntity, UUID> {
}