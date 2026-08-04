package com.krizaldis.distributedsystem.common.domain

import com.krizaldis.distributedsystem.common.id.AggregateId

abstract class Entity<ID : AggregateId>(open val id: ID) {
    override fun equals(other: Any?): Boolean =
        this === other ||
                (other is Entity<*> && id == other.id)

    override fun hashCode(): Int =
        id.hashCode()
}