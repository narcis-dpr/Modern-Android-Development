package com.narcis.datastore.viewModel

import com.narcis.datastore.data.Tasks
import com.narcis.datastore.mediator.TaskService
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@Suppress("DEPRECATION")
class TaskViewModelTest {
    private lateinit var classToTest: TaskViewModel
    private val mockTaskService = mockk<TaskService>()
    private val dispatchers = TestCoroutineDispatcher()
    private val coroutineDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        classToTest = TaskViewModel(mockTaskService)
        Dispatchers.setMain(dispatchers)
    }

    @Test
    fun `Verify add tasks function adds tasks as needed`() = runBlocking {
        val fakeTasks = Tasks(
            firstTask = "finish school work",
            secondTask = "buy gifts for holiday",
            thirdTask = "finish work"
        )
        val expected = classToTest.saveTaskData(fakeTasks)
        assertNotNull(expected)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}