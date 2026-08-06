package com.krizaldis.distributedsystem.order.api.value

data class Address(
    val street: String,
    val city: String,
    val postalCode: String,
    val country: String
)