package com.krizaldis.distributedsystem.order.infrastructure.web.advice

import com.krizaldis.distributedsystem.common.exception.DomainException
import com.krizaldis.distributedsystem.order.infrastructure.web.response.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import java.time.Instant

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DomainException::class)
    fun handle(exception: DomainException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    timestamp = Instant.now(),
                    status = HttpStatus.BAD_REQUEST.value(),
                    error = HttpStatus.BAD_REQUEST.reasonPhrase,
                    message = exception.message ?: "",
                    path = request.requestURI
                )
            )
    }

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