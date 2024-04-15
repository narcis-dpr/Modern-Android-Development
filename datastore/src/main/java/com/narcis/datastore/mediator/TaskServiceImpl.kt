package com.narcis.datastore.mediator

import com.narcis.datastore.data.DataStoreManager
import com.narcis.datastore.data.Tasks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskServiceImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager
): TaskService{
    override fun getTasksFromPrefDataStore(): Flow<Tasks> =
        dataStoreManager.getTasks()


    override suspend fun addTasks(tasks: Tasks) {
        dataStoreManager.saveTasks(tasks)
    }
}