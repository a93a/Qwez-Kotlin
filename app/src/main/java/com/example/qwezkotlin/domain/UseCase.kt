package com.example.qwezkotlin.domain

import com.example.qwezkotlin.data.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            //Timber.d(e)
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}