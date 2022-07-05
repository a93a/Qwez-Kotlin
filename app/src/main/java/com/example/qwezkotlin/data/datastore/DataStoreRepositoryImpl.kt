package com.example.qwezkotlin.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.example.qwezkotlin.data.datastore.DataStoreRepositoryImpl.PreferencesKeys.FIRST_TIME
import com.example.qwezkotlin.data.datastore.DataStoreRepositoryImpl.PreferencesKeys.IS_REMEMBER
import com.example.qwezkotlin.data.datastore.DataStoreRepositoryImpl.PreferencesKeys.REMEMBER
import com.example.qwezkotlin.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): DataStoreRepository {

    companion object {
        const val PREFERENCE_NAME = "qwez"
    }

    object PreferencesKeys {
        val FIRST_TIME = booleanPreferencesKey("first time")
        val REMEMBER = stringPreferencesKey("remember")
        val IS_REMEMBER = booleanPreferencesKey("is remember")
    }

    override suspend fun notFirstTime(setTo: Boolean) {
        dataStore.edit {
            it[FIRST_TIME] = setTo
        }
    }

    override val notFirstTime =
        dataStore.data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
            .map {
            it[FIRST_TIME] ?: false
        }

    override suspend fun setRemembered(toRemember: String) {
        dataStore.edit {
            it[REMEMBER] = toRemember
        }
    }

    override val getRemembered =
        dataStore.data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
            .map {
            it[REMEMBER] ?: ""
        }

    override suspend fun isRemember(remember: Boolean) {
        dataStore.edit {
            it[IS_REMEMBER] = remember
        }
    }

    override val isRemembered =
        dataStore.data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
            .map {
            it[IS_REMEMBER] ?: false
        }

}