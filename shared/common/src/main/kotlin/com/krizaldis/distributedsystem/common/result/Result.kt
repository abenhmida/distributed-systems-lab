package com.krizaldis.distributedsystem.common.result

sealed interface Result<out T>

data class Success<out T>(val value: T) : Result<T>
data class Failure<out T>(val error: DomainError) : Result<T>

fun <T> success(value: T): Result<T> = Success(value)
fun <T> failure(error: DomainError): Result<Nothing> = Failure(error)

inline fun <T, R> Result<T>.map(transform: (T) -> R): Result<R> = when (this) {
    is Success -> Success(transform(value))
    is Failure -> Failure(error)
}

inline fun <T, R> Result<T>.flatMap(transform: (T) -> Result<R>): Result<R> = when (this) {
    is Success -> transform(value)
    is Failure -> Failure(error)
}

inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Success) {
        action(value)
    }
    return this
}

inline fun <T> Result<T>.onFailure(action: (DomainError) -> Unit): Result<T> {
    if (this is Failure) {
        action(error)
    }
    return this
}

inline fun <T> Result<T>.recover(action: (DomainError) -> T): Result<T> = when (this) {
    is Success -> this
    is Failure -> Success(action(error))
}