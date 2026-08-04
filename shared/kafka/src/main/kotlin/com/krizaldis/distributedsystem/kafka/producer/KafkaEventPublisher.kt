package com.krizaldis.distributedsystem.kafka.producer

import com.krizaldis.distributedsystem.common.messaging.EventPublisher
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaEventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>
) : EventPublisher {
    override fun publish(topic: String, key: String, payload: String) {
        kafkaTemplate.send(topic, key, payload).get()
    }
}