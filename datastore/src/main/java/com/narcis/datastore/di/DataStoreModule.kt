package com.narcis.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import androidx.datastore.preferences.preferencesDataStore
import com.narcis.datastore.TaskPreference
import com.narcis.datastore.data.TaskSerializer
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    private val Context.tasksPreferenceStore: DataStore<Preferences> by preferencesDataStore(name = "store_tasks")
    private val Context.taskProtoDataStore: DataStore<TaskPreference> by dataStore(
        fileName = "task.pd",
        serializer = TaskSerializer
    )

    @Singleton
    @Provides
    fun provideTasksPreferenceDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.tasksPreferenceStore

    @Singleton
    @Provides
    fun provideTasksProtoDataStore(
        @ApplicationContext context: Context
    ): DataStore<TaskPreference> = context.taskProtoDataStore
}