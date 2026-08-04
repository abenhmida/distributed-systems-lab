package com.krizaldis.distributedsystem.common.event

@JvmInline
value class EventVersion(val value: Int) {
    init {
        require(value >= 1) { "Event version must be greater than or equal to 1" }
    }

    override fun toString(): String {
        return value.toString()
    }
}