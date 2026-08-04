package com.krizaldis.distributedsystem.order.infrastructure.outbox.retry

import org.springframework.stereotype.Component
import java.time.Instant

@Component
class ExponentialRetryPolicy : RetryPolicy {
    override fun nextRetry(retryCount: Int): Instant {
        val delay = when (retryCount) {
            0 -> 30L
            1 -> 60L
            2 -> 120L
            3 -> 300L
            else -> 900L
        }
        return Instant.now().plusSeconds(delay)
    }
}