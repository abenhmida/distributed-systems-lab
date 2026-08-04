package com.krizaldis.distributedsystem.common.event

import java.time.Instant

data class EventMetadata(
    val eventId: String,
    val aggregateId: String,
    val aggregateType: String,
    val eventType: String,
    val version: Int,
    val occurredAt: Instant,
    val correlationId: String? = null,
    val causationId: String? = null,
    val tenantId: String? = null

)