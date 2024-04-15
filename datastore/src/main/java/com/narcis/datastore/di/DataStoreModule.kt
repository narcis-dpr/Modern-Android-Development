package com.narcis.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import androidx.datastore.preferences.preferencesDataStore
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    private val Context.tasksPreferenceStore : DataStore<Preferences> by preferencesDataStore(name = "store_tasks")

    @Singleton
    @Provides
    fun provideTasksPreferenceDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.tasksPreferenceStore
}