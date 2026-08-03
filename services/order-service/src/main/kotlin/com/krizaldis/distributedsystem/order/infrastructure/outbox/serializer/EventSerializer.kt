package com.krizaldis.distributedsystem.order.infrastructure.outbox.serializer

interface EventSerializer {
    fun serialize(order: Any): String
}