package com.krizaldis.distributedsystem.common.messaging
import java.util.UUID

@JvmInline
value class RequestId(
    val value: UUID
)