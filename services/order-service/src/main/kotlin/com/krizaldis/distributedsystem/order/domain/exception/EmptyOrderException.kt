package com.krizaldis.distributedsystem.order.domain.exception

import com.krizaldis.common.exception.DomainException

class EmptyOrderException (message: String) : DomainException(message)