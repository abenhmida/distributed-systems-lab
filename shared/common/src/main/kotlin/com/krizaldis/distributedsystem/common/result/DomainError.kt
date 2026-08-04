package com.krizaldis.distributedsystem.common.result

data class DomainError (
    val code: ErrorCode,
    val message: String,
    val details: Map<String, Any?> = emptyMap()
)