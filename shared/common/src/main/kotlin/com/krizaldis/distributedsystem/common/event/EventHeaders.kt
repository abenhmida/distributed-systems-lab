package com.krizaldis.distributedsystem.common.event

data class EventHeaders(
    private val values: Map<String, String> = emptyMap()
) {
    operator fun get(key: String): String? = values[key]

    fun plus(key: String, value: String): EventHeaders =
        copy(values = values + (key to value))

    fun asMap(): Map<String, String> = values
}
