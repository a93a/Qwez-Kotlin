package com.example.qwezkotlin.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.qwezkotlin.data.local.entity.GameQuestion
import com.example.qwezkotlin.data.local.entity.Question
import kotlinx.coroutines.flow.Flow


@Dao
interface GameQuestionDao {

    @Query("SELECT * FROM games")
    fun getGameQuestions(): Flow<List<GameQuestion>>

    @Query("SELECT * FROM games WHERE id=:id")
    fun getGameQuestionById(id: Int): Flow<GameQuestion>

    @Query("SELECT * FROM questions where questions.answer_chosen=questions.correct_answer and questions.question_id=:gameId")
    suspend fun getPoints(gameId: Int): List<Question>
}