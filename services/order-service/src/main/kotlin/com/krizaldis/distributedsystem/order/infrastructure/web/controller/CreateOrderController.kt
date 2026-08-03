package com.krizaldis.distributedsystem.order.infrastructure.web.controller

import com.krizaldis.common.result.Failure
import com.krizaldis.common.result.Success
import com.krizaldis.distributedsystem.order.application.port.inbound.CreateOrderUseCase
import com.krizaldis.distributedsystem.order.infrastructure.web.mapper.OrderWebMapper
import com.krizaldis.distributedsystem.order.infrastructure.web.request.CreateOrderRequest
import com.krizaldis.distributedsystem.order.infrastructure.web.response.OrderResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/orders")
class CreateOrderController(
    private val createOrderUseCase: CreateOrderUseCase
) {
    @PostMapping
    fun post(@RequestBody @Valid request: CreateOrderRequest): ResponseEntity<OrderResponse> {
        return when (
            val result = createOrderUseCase.create(
                OrderWebMapper.toCommand(request)
            )
        ) {
            is Success -> ResponseEntity.status(HttpStatus.CREATED)
                .body(OrderWebMapper.toResponse(result.value))

            is Failure -> throw ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                result.error.message
            )
        }
    }
}