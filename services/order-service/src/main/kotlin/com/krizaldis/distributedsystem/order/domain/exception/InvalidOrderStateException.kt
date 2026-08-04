package com.krizaldis.distributedsystem.order.domain.exception

import com.krizaldis.distributedsystem.common.exception.DomainException

class InvalidOrderStateException(message: String) : DomainException(message)