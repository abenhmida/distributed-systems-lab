package com.krizaldis.distributedsystem.order.infrastructure.outbox

import com.krizaldis.common.domain.DomainEvent
import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent

interface OutboxEventFactory {
    fun from(
        aggregateType: String,
        event: DomainEvent

    ): OutboxEvent
}