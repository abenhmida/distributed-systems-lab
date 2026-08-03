package com.krizaldis.distributedsystem.order.infrastructure.web.controller

import com.krizaldis.common.id.OrderId
import com.krizaldis.common.result.Failure
import com.krizaldis.common.result.Success
import com.krizaldis.distributedsystem.order.infrastructure.web.mapper.OrderWebMapper
import com.krizaldis.distributedsystem.order.infrastructure.web.response.OrderResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("/api/v1/orders")
class GetOrderController(
    private val getOrderUseCase: GetOrderUseCase
) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): OrderResponse {

        val result =
            getOrderUseCase.get(
                OrderId(id)

            )

        return when (result) {

            is Success ->

                OrderWebMapper.toResponse(

                    result.value

                )

            is Failure ->

                throw ResponseStatusException(

                    HttpStatus.NOT_FOUND,

                    result.error.message

                )

        }

    }

}