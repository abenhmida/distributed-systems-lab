package com.krizaldis.distributedsystem.common.domain

import com.krizaldis.distributedsystem.common.id.AggregateId

abstract class VersionedAggregate<ID : AggregateId>(
    id: ID,
    open var version: Long = 0,
) : AggregateRoot<ID>(id) {
}