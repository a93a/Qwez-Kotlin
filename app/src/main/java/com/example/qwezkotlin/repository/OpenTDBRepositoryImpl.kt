package com.example.qwezkotlin.repository

import com.example.qwezkotlin.repository.db.entity.Question
import com.example.qwezkotlin.repository.opentdb.ApiResult
import com.example.qwezkotlin.repository.opentdb.OpenTDBAPI
import retrofit2.HttpException
import retrofit2.Response

class OpenTDBRepositoryImpl(
    private val api: OpenTDBAPI
): OpenTDBRepository {
    override suspend fun getQuestionByCategory(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Question> {
        handleApi { api.getQuestions(amount,category,difficulty,type) }
    }

    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): ApiResult<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                ApiResult.Success(body)
            } else {
                ApiResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            ApiResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            ApiResult.Exception(e)
        }
    }

}