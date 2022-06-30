package com.example.qwezkotlin.repository

import com.example.qwezkotlin.repository.db.entity.Question

interface OpenTDBRepository {

    suspend fun getQuestionByCategory(amount: Int, category: Int, difficulty: String, type: String): List<Question>

}