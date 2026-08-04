package com.krizaldis.distributedsystem.order.infrastructure.outbox.retry

import java.time.Instant

interface RetryPolicy {
    fun nextRetry(retryCount: Int): Instant
}