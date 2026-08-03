package com.krizaldis.distributedsystem.order.infrastructure.web.response

import java.time.Instant

data class ErrorResponse(
    val timestamp: Instant,
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)