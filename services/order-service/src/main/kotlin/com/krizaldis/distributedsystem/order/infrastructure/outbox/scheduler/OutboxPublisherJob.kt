package com.krizaldis.distributedsystem.order.infrastructure.outbox.scheduler

import com.krizaldis.distributedsystem.order.infrastructure.outbox.publisher.OutboxPublisherService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class OutboxPublisherJob(
    private val publisher: OutboxPublisherService
) {
    @Scheduled(fixedDelayString = "\${outbox.poll-interval:1000}")
    fun run() {
        publisher.publishBatch()
    }
}