package com.krizaldis.distributedsystem.order.infrastructure.persistence.adapter

import com.krizaldis.common.id.OrderId
import com.krizaldis.distributedsystem.order.application.port.outbound.ExistsOrderPort
import com.krizaldis.distributedsystem.order.application.port.outbound.LoadOrderPort
import com.krizaldis.distributedsystem.order.application.port.outbound.SaveOrderPort
import com.krizaldis.distributedsystem.order.domain.model.Order
import com.krizaldis.distributedsystem.order.infrastructure.persistence.mapper.OrderEntityMapper
import com.krizaldis.distributedsystem.order.infrastructure.persistence.repository.SpringDataOrderRepository
import org.springframework.stereotype.Component

@Component
class JpaOrderRepositoryAdapter(
    private val repository: SpringDataOrderRepository
) : SaveOrderPort, LoadOrderPort, ExistsOrderPort {
    override fun save(order: Order): Order {
        val saved = repository.save(
            OrderEntityMapper.toEntity(order)
        )

        return OrderEntityMapper.toDomain(saved)
    }

    override fun load(id: OrderId): Order? = repository.findById(id.value)
        .map(OrderEntityMapper::toDomain)
        .orElse(null)

    override fun exists(id: OrderId): Boolean = repository.existsById(id.value)
}