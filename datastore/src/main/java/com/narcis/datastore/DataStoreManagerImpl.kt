package com.narcis.datastore

import kotlinx.coroutines.flow.Flow

class DataStoreManagerImpl(): DataStoreManager {
    override suspend fun saveTasks(tasks: Tasks) {
        TODO("Not yet implemented")
    }

    override fun getTasks(): Flow<Tasks> {
        TODO("Not yet implemented")
    }
}