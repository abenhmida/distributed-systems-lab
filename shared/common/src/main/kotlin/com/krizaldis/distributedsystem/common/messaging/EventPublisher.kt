package com.krizaldis.distributedsystem.common.messaging

interface EventPublisher {
    fun publish(topic: String, key: String, payload: String)
}