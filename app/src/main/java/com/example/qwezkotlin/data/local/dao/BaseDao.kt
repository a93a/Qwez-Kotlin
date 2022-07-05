package com.example.qwezkotlin.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    suspend fun insert(t: T)

    @Insert
    suspend fun insert(vararg t: T)

    @Update
    suspend fun update(t: T)

    @Delete
    suspend fun delete(t: T)
}