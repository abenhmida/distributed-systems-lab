package com.krizaldis.distributedsystem.order.api.value

@JvmInline
value class Email(val value: String) {
    init {
        require(value.contains("@")) {
            "Invalid email."
        }
    }
}