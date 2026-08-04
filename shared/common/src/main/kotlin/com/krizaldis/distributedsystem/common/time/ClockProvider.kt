package com.krizaldis.distributedsystem.common.time

import java.time.Instant

fun interface ClockProvider {
    fun now(): Instant
}