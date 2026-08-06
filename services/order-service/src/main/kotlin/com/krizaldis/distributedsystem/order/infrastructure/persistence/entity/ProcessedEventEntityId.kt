package com.krizaldis.distributedsystem.order.infrastructure.persistence.entity

import jakarta.persistence.Column
import java.util.UUID

class ProcessedEventEntityId(
    @Column(name = "event_id")
    val id: UUID,

    @Column(name = "consumer_name")
    val consumerName: String,
)