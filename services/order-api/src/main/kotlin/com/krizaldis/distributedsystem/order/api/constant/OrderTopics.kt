package com.krizaldis.distributedsystem.order.api.constant

/**
 * Topics belong to the API
 * Every producer and consumer must agree on them
 */
object OrderTopics {
    const val ORDER_EVENTS = "orders.events"
    const val ORDER_COMMANDS = "orders.commands"
}