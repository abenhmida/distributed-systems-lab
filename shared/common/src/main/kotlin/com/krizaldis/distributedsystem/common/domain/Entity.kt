package com.krizaldis.distributedsystem.common.domain

abstract class Entity<ID>(open val id: ID) {
    override fun equals(other: Any?): Boolean =
        this === other ||
                (other is Entity<*> && id == other.id)

    override fun hashCode(): Int =
        id.hashCode()
}