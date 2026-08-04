package com.krizaldis.distributedsystem.common.serialization

class SerializationException(

    message: String,

    cause: Throwable

) : RuntimeException(message, cause)