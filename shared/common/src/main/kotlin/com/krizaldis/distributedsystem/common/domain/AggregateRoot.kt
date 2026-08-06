package com.krizaldis.distributedsystem.common.domain

abstract class AggregateRoot<ID>(
    open val id: ID
) {
    private val events = mutableListOf<DomainEvent>()

    protected open fun registerEvent(event: DomainEvent) {
        events += event
    }

    fun domainEvents(): List<DomainEvent> = events.toList()
    fun clearDomainEvents() = events.clear()
}