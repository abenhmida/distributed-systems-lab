package com.krizaldis.distributedsystem.order.infrastructure.outbox.publisher

import com.krizaldis.distributedsystem.common.messaging.EventPublisher
import com.krizaldis.distributedsystem.order.infrastructure.outbox.OutboxRepository
import com.krizaldis.distributedsystem.order.infrastructure.outbox.model.OutboxEvent
import com.krizaldis.distributedsystem.order.infrastructure.outbox.retry.RetryPolicy
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class OutboxPublisherService(
    private val repository: OutboxRepository,
    private val publisher: EventPublisher,
    private val retryPolicy: RetryPolicy
) {
    companion object {
        const val TOPIC = "orders.events"
        const val BATCH_SIZE = 100
    }

    private val logger = LoggerFactory.getLogger(javaClass)

    fun publishBatch() {
        repository.findPending(BATCH_SIZE)
            .forEach { event ->
                publish(event)
            }
    }

    private fun publish(event: OutboxEvent) {
        try {
            publisher.publish(
                topic = TOPIC,
                key = event.aggregateId,
                payload = event.payload
            )

            repository.markPublished(
                event.id, Instant.now(),
            )
            logger.info("Published {}", event.id)
        } catch (exception: Exception) {
            logger.error("Publishing failed {}", event.id, exception)

            repository.scheduleRetry(
                event.copy(
                    retryCount = event.retryCount + 1,
                    nextRetryAt = retryPolicy.nextRetry(event.retryCount),
                    updatedAt = Instant.now()
                )
            )
        }
    }
}