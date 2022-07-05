package com.example.qwezkotlin.data.remote

import com.example.qwezkotlin.data.local.entity.Question
import com.example.qwezkotlin.data.util.Result
import com.example.qwezkotlin.domain.repository.OpenTDBRepository
import kotlinx.coroutines.flow.Flow

class OpenTDBRepositoryImpl(
    private val api: OpenTDBAPI
): OpenTDBRepository {
    override fun getQuestionByCategory(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): Flow<Result<List<Question>>> {
        TODO("Not yet implemented")
    }


}