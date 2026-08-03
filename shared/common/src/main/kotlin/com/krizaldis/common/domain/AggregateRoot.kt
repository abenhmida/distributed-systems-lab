package com.krizaldis.common.domain

import com.krizaldis.common.id.AggregateId

open class AggregateRoot<ID: AggregateId>(id: ID): Entity<ID>(id) {
    private val events = mutableListOf<DomainEvent>()

    protected fun registerEvent(event: DomainEvent) {
        events += event
    }

    fun domainEvents(): List<DomainEvent> = events.toList()
    fun clearDomainEvents() = events.clear()
}