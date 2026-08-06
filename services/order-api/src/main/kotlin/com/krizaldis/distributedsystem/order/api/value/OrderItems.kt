package com.krizaldis.distributedsystem.order.api.value

data class OrderItems(
    private val items: List<OrderItem>
) {
    init {
        require(items.isNotEmpty()) {
            "An order must contain at least one item."
        }

        require(
            items.distinctBy { it.productId }.size == items.size
        ) {
            "Duplicate products are not allowed."
        }
    }

    fun total(): Money = items
        .map { it.subtotal() }
        .reduce(Money::plus)

    fun asList(): List<OrderItem> = items.toList()
}
