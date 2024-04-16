package com.narcis.datastore.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.narcis.datastore.R
import com.narcis.datastore.data.Tasks
import com.narcis.datastore.screen.components.TaskButton
import com.narcis.datastore.screen.components.TaskTextField
import com.narcis.datastore.viewModel.TaskViewModel

@Composable
fun TaskScreen(taskViewModel: TaskViewModel) {
    val firstText = remember {
        mutableStateOf("")
    }
    val secondText = remember {
        mutableStateOf("")
    }
    val thirdText = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TaskTextField(text = firstText.value, onFieldChange = { firstText.value = it },
            label = { Text(text = stringResource(id = R.string.enter_first_task)) })
        TaskTextField(text = secondText.value, onFieldChange = { secondText.value = it },
            label = { Text(text = stringResource(id = R.string.enter_second_task)) })

        TaskTextField(text = thirdText.value, onFieldChange = { thirdText.value = it },
            label = { Text(text = stringResource(id = R.string.enter_third_task)) })

        TaskButton(onClick = {
            val tasks = Tasks(
                firstTask = firstText.value,
                secondTask = secondText.value,
                thirdTask = thirdText.value
            )
            taskViewModel.saveTaskData(tasks)
        }, text = stringResource(id = R.string.save))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 16.dp, end = 10.dp)
        ) {
            item { taskViewModel.taskList }
        }

    }
}