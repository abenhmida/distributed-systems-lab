package com.krizaldis.common.time

import java.time.Instant

fun interface ClockProvider {
    fun now(): Instant
}