package com.krizaldis.distributedsystem.common.event

@JvmInline
value class EventType(val value: String) {
    override fun toString(): String = value
}