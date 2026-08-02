package com.krizaldis.common.id

import java.io.Serializable

abstract class TypedId<T : Any>(
    open val value: T,
) : Serializable {

    override fun equals(other: Any?): Boolean {
        return this === other || (
                other != null && this::class == other::class &&
                        value == (other as TypedId<*>).value
                )
    }

    override fun hashCode(): Int =
        value.hashCode()

    override fun toString(): String =
        value.toString()
}