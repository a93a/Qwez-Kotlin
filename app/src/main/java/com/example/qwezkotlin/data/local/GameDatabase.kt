package com.example.qwezkotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.qwezkotlin.data.local.GameDatabase.Companion.DATABASE_VERSION
import com.example.qwezkotlin.data.local.dao.GameDao
import com.example.qwezkotlin.data.local.dao.GameQuestionDao
import com.example.qwezkotlin.data.local.dao.QuestionDao
import com.example.qwezkotlin.data.local.entity.Game
import com.example.qwezkotlin.data.local.entity.Question


@Database(entities = [Game::class, Question::class], version = DATABASE_VERSION)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
    abstract fun questionDao(): QuestionDao
    abstract fun gameQuestionDao(): GameQuestionDao

    companion object {
        const val DATABASE_NAME = "game_database"
        const val DATABASE_VERSION: Int = 1
    }
}