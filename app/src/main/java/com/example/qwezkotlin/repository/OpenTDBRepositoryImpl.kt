package com.example.qwezkotlin.repository

import com.example.qwezkotlin.repository.db.entity.Question
import com.example.qwezkotlin.repository.opentdb.OpenTDBAPI

class OpenTDBRepositoryImpl(
    private val api: OpenTDBAPI
): OpenTDBRepository {
    override suspend fun getQuestionByCategory(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Question> {
        TODO("Not yet implemented")
    }

}