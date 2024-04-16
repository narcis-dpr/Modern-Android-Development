package com.narcis.datastore.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narcis.datastore.data.TaskDataSource
import com.narcis.datastore.data.Tasks
import com.narcis.datastore.mediator.TaskService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskService: TaskService
): ViewModel() {
val taskList: Flow<Tasks> = taskService.getTasksFromPrefDataStore()

   fun saveTaskData(tasks: Tasks) {
       viewModelScope.launch {
           Log.d("Task", "asdf Data was inserted correctly")
            taskService.addTasks(tasks)
       }
   }
}