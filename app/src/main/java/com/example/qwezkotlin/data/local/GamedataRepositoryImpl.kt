package com.example.qwezkotlin.data.local

import com.example.qwezkotlin.data.local.entity.Game
import com.example.qwezkotlin.data.local.entity.GameQuestion
import com.example.qwezkotlin.data.local.entity.Question
import com.example.qwezkotlin.data.util.Result
import com.example.qwezkotlin.domain.repository.GameDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GamedataRepositoryImpl @Inject constructor(
    private val gameDatabase: GameDatabase
): GameDataRepository {
    override fun getAllGames(): Flow<Result<List<Game>>> {
        TODO("Not yet implemented")
    }

    override suspend fun addGame(game: Game) {
        TODO("Not yet implemented")
    }

    override fun addGameReturnId(game: Game): Flow<Result<Long>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteGame(game: Game) {
        TODO("Not yet implemented")
    }

    override suspend fun updateGame(game: Game) {
        TODO("Not yet implemented")
    }

    override fun getAllQuestions(): Flow<Result<List<Question>>> {
        TODO("Not yet implemented")
    }

    override suspend fun addQuestion(question: Question) {
        TODO("Not yet implemented")
    }

    override suspend fun addQuestions(questions: List<Question>) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteQuestion(question: Question) {
        TODO("Not yet implemented")
    }

    override suspend fun updateQuestion(question: Question) {
        TODO("Not yet implemented")
    }

    override fun getAllGamesAndQuestions(): Flow<Result<List<GameQuestion>>> {
        TODO("Not yet implemented")
    }

    override fun getGameQuestionBy(id: Int): Flow<Result<GameQuestion>> {
        TODO("Not yet implemented")
    }

    override fun updateQuestionAndReturnId(question: Question): Flow<Result<Int>> {
        TODO("Not yet implemented")
    }

    override fun getSingleQuestionById(id: Int): Flow<Result<Question>> {
        TODO("Not yet implemented")
    }

    override fun getGameById(id: Int): Flow<Result<Game>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun getAllCorrectQuestions(id: Int): Flow<Result<List<Question>>> {
        TODO("Not yet implemented")
    }

    override fun getAllQuestionsByGameId(id: Int): Flow<Result<List<Question>>> {
        TODO("Not yet implemented")
    }


}