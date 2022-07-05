package com.example.qwezkotlin.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun notFirstTime(setTo: Boolean)

    val notFirstTime: Flow<Boolean>

    suspend fun setRemembered(toRemember: String)

    val getRemembered: Flow<String>

    suspend fun isRemember(remember: Boolean)

    val isRemembered: Flow<Boolean>

}