package com.narcis.datastore.mediator

import com.narcis.datastore.data.DataStoreManager
import com.narcis.datastore.data.Tasks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface TaskService {
    fun getTasksFromPrefDataStore(): Flow<Tasks>
    suspend fun addTasks(tasks: Tasks)
    fun getTasks(): Flow<Tasks>
     fun getTasksFromProtoStore(): Flow<Tasks>
}