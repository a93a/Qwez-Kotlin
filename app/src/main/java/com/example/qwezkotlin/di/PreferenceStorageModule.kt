package com.example.qwezkotlin.di

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.preferencesDataStore
import com.example.qwezkotlin.data.datastore.DataStoreRepositoryImpl
import com.example.qwezkotlin.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PreferenceStorageModule {

    val Context.dataStore by preferencesDataStore(
        name = DataStoreRepositoryImpl.PREFERENCE_NAME,
        produceMigrations = { context ->
            listOf(
                SharedPreferencesMigration(
                    context,
                    DataStoreRepositoryImpl.PREFERENCE_NAME
                )
            )
        }
    )

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context): DataStoreRepository =
        DataStoreRepositoryImpl(context.dataStore)

}