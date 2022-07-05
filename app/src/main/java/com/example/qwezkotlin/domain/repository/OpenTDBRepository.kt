package com.example.qwezkotlin.domain.repository

import com.example.qwezkotlin.data.local.entity.Question
import com.example.qwezkotlin.data.util.Result
import kotlinx.coroutines.flow.Flow

interface OpenTDBRepository {

    fun getQuestionByCategory(amount: Int, category: Int, difficulty: String, type: String): Flow<Result<List<Question>>>

}