package com.narcis.datastore.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narcis.datastore.data.Tasks
import com.narcis.datastore.mediator.TaskService
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskViewModel @Inject constructor(
    private val taskService: TaskService
): ViewModel() {

   fun saveTaskData(tasks: Tasks) {
       viewModelScope.launch {
           Log.d("Task", "asdf Data was inserted correctly")
            taskService.addTasks(tasks)
       }
   }
}