package com.krizaldis.distributedsystem.order.application.service

import com.krizaldis.common.id.OrderId
import com.krizaldis.common.result.*
import com.krizaldis.distributedsystem.order.application.dto.OrderDto
import com.krizaldis.distributedsystem.order.application.mapper.OrderMapper
import com.krizaldis.distributedsystem.order.application.port.inbound.GetOrderUseCase
import com.krizaldis.distributedsystem.order.application.port.outbound.LoadOrderPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetOrderService(
    private val loadOrderPort: LoadOrderPort,
) : GetOrderUseCase {

    override fun get(orderId: OrderId): Result<OrderDto> {
        val order = loadOrderPort.load(orderId)
            ?: return failure<OrderDto>(
                DomainError(
                    code = ErrorCode.NOT_FOUND,
                    message = "Order with id ${orderId.value} not found"
                )
            )

        return success(OrderMapper.toOrder(order))
    }
}
