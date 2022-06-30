package com.example.qwezkotlin.repository

import com.example.qwezkotlin.repository.db.entity.Game
import com.example.qwezkotlin.repository.db.entity.GameQuestion
import com.example.qwezkotlin.repository.db.entity.Question
import kotlinx.coroutines.flow.Flow


interface GamedataRepository {
    suspend fun getAllGames(): Flow<List<Game>>

    suspend fun addGame(game: Game)

    suspend fun addGameReturnId(game: Game): Long

    suspend fun deleteGame(game: Game)

    suspend fun updateGame(game: Game)

    suspend fun getAllQuestions(): List<Question>

    suspend fun addQuestion(question: Question)

    suspend fun addQuestions(questions: List<Question>)

    suspend fun deleteQuestion(question: Question)

    suspend fun updateQuestion(question: Question)

    suspend fun getAllGamesAndQuestions(): Flow<List<GameQuestion>>

    suspend fun getGameQuestionBy(id: Int): Flow<GameQuestion>

    suspend fun updateQuestionAndReturnId(question: Question): Int

    suspend fun getSingleQuestionById(id: Int): Question

    suspend fun getGameById(id: Int): Game

    suspend fun deleteAll()

    suspend fun getAllCorrectQuestions(id: Int): List<Question>

    suspend fun getAllQuestionsByGameId(id: Int): Flow<List<Question>>
}