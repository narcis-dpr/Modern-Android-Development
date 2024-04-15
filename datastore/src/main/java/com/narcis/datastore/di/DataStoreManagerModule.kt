package com.narcis.datastore.di

import com.narcis.datastore.data.DataStoreManager
import com.narcis.datastore.data.DataStoreManagerImpl
import com.narcis.datastore.mediator.TaskService
import com.narcis.datastore.mediator.TaskServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreManagerModule {
    @Singleton
    @Binds
    abstract fun bindDataStoreRepository(dataStoreManagerImpl: DataStoreManagerImpl): DataStoreManager

    @Singleton
    @Binds
    abstract fun bindTaskService(taskServiceImpl: TaskServiceImpl): TaskService
}