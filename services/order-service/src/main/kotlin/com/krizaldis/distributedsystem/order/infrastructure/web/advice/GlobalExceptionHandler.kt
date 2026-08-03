package com.krizaldis.distributedsystem.order.infrastructure.web.advice

import com.krizaldis.distributedsystem.order.infrastructure.web.response.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import java.time.Instant

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException::class)
    fun handle(exception: ResponseStatusException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(exception.statusCode)
            .body(
                ErrorResponse(
                    timestamp = Instant.now(),
                    status = exception.statusCode.value(),
                    error = exception.statusCode.toString(),
                    message = exception.reason ?: "",
                    path = request.requestURI
                )
            )
    }
}