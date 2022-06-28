package com.example.qwezkotlin.repository.db

import com.example.qwezkotlin.repository.GamedataRepository
import com.example.qwezkotlin.repository.db.dao.GameDao
import com.example.qwezkotlin.repository.db.dao.GameQuestionDao
import com.example.qwezkotlin.repository.db.dao.QuestionDao
import com.example.qwezkotlin.repository.db.entity.Game
import com.example.qwezkotlin.repository.db.entity.GameQuestion
import com.example.qwezkotlin.repository.db.entity.Question
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GamedataRepositoryImpl @Inject constructor(
    private val gameDao: GameDao,
    private val questionDao: QuestionDao,
    private val gameQuestionDao: GameQuestionDao,
    private val gameDatabase: GameDatabase
): GamedataRepository {

    override suspend fun getAllGames(): Flow<List<Game>> {
        return gameDao.getAll()
    }

    override suspend fun addGame(game: Game) {
        return gameDao.insert(game)
    }

    override suspend fun addGameReturnId(game: Game): Long {
        return gameDao.insertReturnId(game)
    }

    override suspend fun deleteGame(game: Game) {
        return gameDao.delete(game)
    }

    override suspend fun updateGame(game: Game) {
        return gameDao.update(game)
    }

    override suspend fun getAllQuestions(): List<Question> {
        return questionDao.getAll()
    }

    override suspend fun addQuestion(question: Question) {
        return questionDao.insert(question)
    }

    override suspend fun addQuestions(questions: List<Question>) {
        return questionDao.insert(*questions.toTypedArray())
    }

    override suspend fun deleteQuestion(question: Question) {
        return questionDao.delete(question)
    }

    override suspend fun updateQuestion(question: Question) {
        questionDao.update(question)
    }

    override suspend fun getAllGamesAndQuestions(): Flow<List<GameQuestion>> {
        return gameQuestionDao.getGameQuestions()
    }

    override suspend fun getGameQuestionBy(id: Int): Flow<GameQuestion> {
        return gameQuestionDao.getGameQuestionById(id)
    }

    override suspend fun updateQuestionAndReturnId(question: Question): Int {
        return questionDao.insertAndReturnId(question)
    }

    override suspend fun getSingleQuestionById(id: Int): Question {
        return questionDao.getById(id)
    }

    override suspend fun getGameById(id: Int): Game {
        return gameDao.getGameById(id)
    }

    override suspend fun deleteAll() {
        return gameDatabase.clearAllTables()
    }

    override suspend fun getAllCorrectQuestions(id: Int): List<Question> {
        return gameQuestionDao.getPoints(id)
    }

    override suspend fun getAllQuestionsByGameId(id: Int): Flow<List<Question>> {
        return questionDao.getAllQuestionsByGameId(id)
    }
}