package com.krizaldis.distributedsystem.order.infrastructure.persistence.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.Version
import java.util.UUID

@Entity
@Table(name = "orders")
class OrderEntity(
    @Id
    val id: UUID,

    @Column(nullable = false)
    val customerId: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: OrderStatus,

    @Version
    var version: Long = 0,

    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY,
    )
    @JoinColumn(name = "order_id", nullable = false)
    val items: MutableList<OrderItemEntity> = mutableListOf(),
)