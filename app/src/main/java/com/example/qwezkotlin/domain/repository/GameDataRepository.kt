package com.example.qwezkotlin.domain.repository

import com.example.qwezkotlin.data.local.entity.Game
import com.example.qwezkotlin.data.local.entity.GameQuestion
import com.example.qwezkotlin.data.local.entity.Question
import com.example.qwezkotlin.data.util.Result
import kotlinx.coroutines.flow.Flow

interface GameDataRepository {
    fun getAllGames(): Flow<Result<List<Game>>>

    suspend fun addGame(game: Game)

    fun addGameReturnId(game: Game): Flow<Result<Long>>

    suspend fun deleteGame(game: Game)

    suspend fun updateGame(game: Game)

    fun getAllQuestions(): Flow<Result<List<Question>>>

    suspend fun addQuestion(question: Question)

    suspend fun addQuestions(questions: List<Question>)

    suspend fun deleteQuestion(question: Question)

    suspend fun updateQuestion(question: Question)

    fun getAllGamesAndQuestions(): Flow<Result<List<GameQuestion>>>

    fun getGameQuestionBy(id: Int): Flow<Result<GameQuestion>>

    fun updateQuestionAndReturnId(question: Question): Flow<Result<Int>>

    fun getSingleQuestionById(id: Int): Flow<Result<Question>>

    fun getGameById(id: Int): Flow<Result<Game>>

    suspend fun deleteAll()

    fun getAllCorrectQuestions(id: Int): Flow<Result<List<Question>>>

    fun getAllQuestionsByGameId(id: Int): Flow<Result<List<Question>>>
}