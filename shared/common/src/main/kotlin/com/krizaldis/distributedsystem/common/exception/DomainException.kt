package com.krizaldis.distributedsystem.common.exception

open class DomainException(
    message: String,
    cause: Throwable? = null,
): RuntimeException(message, cause)