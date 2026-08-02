package com.krizaldis.common.domain

import com.krizaldis.common.id.AggregateId

open class AggregateRoot<ID: AggregateId>(id: ID): Entity<ID>(id) {
    private val domainEvents = mutableListOf<DomainEvent>()

    protected fun registerEvent(event: DomainEvent) {
        domainEvents += event
    }

    fun domainEvents(): List<DomainEvent> = domainEvents.toList()
    fun clearDomainEvents() = domainEvents.clear()
}