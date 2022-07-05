package com.example.qwezkotlin.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.qwezkotlin.data.local.entity.Game
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao: BaseDao<Game> {
    @Insert
    suspend fun insertReturnId(game: Game): Long

    @Query("SELECT * FROM games")
    fun getAll(): Flow<List<Game>>

    @Query("DELETE FROM games WHERE id=:id")
    suspend fun deleteById(id: Int)

    @Query("SELECT * FROM games WHERE id=:id")
    suspend fun getGameById(id: Int): Game

}