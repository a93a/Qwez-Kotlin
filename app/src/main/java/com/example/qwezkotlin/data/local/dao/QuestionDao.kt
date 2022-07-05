package com.example.qwezkotlin.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.qwezkotlin.data.local.entity.Question
import kotlinx.coroutines.flow.Flow


@Dao
interface QuestionDao: BaseDao<Question> {
    @Query("SELECT * FROM questions")
    suspend fun getAll(): List<Question>

    @Query("DELETE FROM questions WHERE question_id=:id")
    suspend fun deleteById(id: Int)

    @Update
    suspend fun insertAndReturnId(question: Question?): Int

    @Query("SELECT * FROM QUESTIONS where id=:id")
    suspend fun getById(id: Int): Question

    @Query("SELECT * FROM QUESTIONS where question_id=:id")
    fun getAllQuestionsByGameId(id: Int): Flow<List<Question>>
}