package com.example.qwezkotlin.repository.opentdb

sealed class ApiResult<T : Any> {
    class Success<T: Any>(val data: T) : ApiResult<T>()
    class Error<T: Any>(val code: Int, val message: String?) : ApiResult<T>()
    class Exception<T: Any>(val e: Throwable) : ApiResult<T>()
}